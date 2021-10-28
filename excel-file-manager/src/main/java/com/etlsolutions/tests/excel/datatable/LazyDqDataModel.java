package com.etlsolutions.tests.excel.datatable;

import com.etlsolutions.excel.cache.AbstractCache;
import java.lang.reflect.Field;
import java.util.*;
import org.apache.log4j.Logger;
import org.omnifaces.el.functions.Arrays;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

public class LazyDqDataModel<T extends IdentifiableRow> extends LazyDataModel<T> {

    private static final long serialVersionUID = 886732626550437281L;

    private List<T> rows;

    @Override
    public T getRowData(String rowKey) {
        for (T row : rows) {
            if (row.getId().equals(rowKey)) {
                return row;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(T row) {

        if (rows.contains(row)) {
            return row.getId();
        }

        return null;
    }

    @Override
    public List<T> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
        try {
            //filter
            List<T> data = filter(filters);

            //sort
            if (multiSortMeta != null) {
                for (SortMeta meta : multiSortMeta) {
                    Collections.sort(data, new LazySorter<>(meta.getSortField(), meta.getSortOrder()));
                }
            }

            //rowCount
            int dataSize = data.size();
            this.setRowCount(dataSize);

            return paginate(dataSize, pageSize, data, first);
        } catch (Throwable th) {

            Logger.getLogger(getClass()).error(th);
            throw new RuntimeException(th);
        }
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        try {
            //filter
            List<T> data = filter(filters);

            //sort
            if (sortField != null) {
                Collections.sort(data, new LazySorter<>(sortField, sortOrder));
            }

            //rowCount
            int dataSize = data.size();
            setRowCount(dataSize);

            //paginate
            return paginate(dataSize, pageSize, data, first);
        } catch (Throwable th) {

            Logger.getLogger(getClass()).error(th);
            throw new RuntimeException(th);
        }
    }

    private List<T> filter(Map<String, Object> filters) {
        List<T> data = new ArrayList<>();
        for (T row : rows) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        String[] filterValue = (String[]) filters.get(filterProperty);
                        Field field = row.getClass().getDeclaredField(filterProperty);
                        field.setAccessible(true);
                        String fieldValue = String.valueOf(field.get(row));

                        if (filterValue != null && !Arrays.contains(filterValue, fieldValue)) {
                            match = false;
                            break;
                        }
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }

            if (match) {
                data.add(row);
            }
        }

        return data;
    }

    private List<T> paginate(int dataSize, int pageSize, List<T> data, int first) {

        if (dataSize <= pageSize) {
            return data;
        }

        if (first + pageSize < data.size()) {
            return data.subList(first, first + pageSize);
        }

        return data.subList(first, first + (dataSize % pageSize));
    }

}
