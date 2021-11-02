package com.etlsolutions.tests.excel.datatable;

import com.etlsolutions.jlrmena.tests.excel.DataRow;
import java.lang.reflect.Field;
import java.util.*;
import org.apache.log4j.Logger;
import org.omnifaces.el.functions.Arrays;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

public class LazyDqDataModel extends LazyDataModel<DataRow> {

    private static final long serialVersionUID = 886732626550437281L;

    private List<DataRow> rows;

    public LazyDqDataModel() {
    }
    
    public LazyDqDataModel(List<DataRow> rows) {
        this.rows = new ArrayList<>(rows);
    }
    
    @Override
    public DataRow getRowData(String rowKey) {
        for (DataRow row : rows) {
            if (row.getId().equals(rowKey)) {
                return row;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(DataRow row) {

        if (rows.contains(row)) {
            return row.getId();
        }

        return null;
    }

    @Override
    public List<DataRow> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
        try {
            //filter
            List<DataRow> data = filter(filters);

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
    public List<DataRow> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        try {
            //filter
            List<DataRow> data = filter(filters);

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

    private List<DataRow> filter(Map<String, Object> filters) {
        List<DataRow> data = new ArrayList<>();
        for (DataRow row : rows) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        
                        Object f = filters.get(filterProperty);
                        String[] filterValue;
                        if(f instanceof String) {
                            filterValue = new String[]{(String)f};
                        } else {
                            filterValue = (String[]) f;
                        }
 
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

    private List<DataRow> paginate(int dataSize, int pageSize, List<DataRow> data, int first) {

        if (dataSize <= pageSize) {
            return data;
        }

        if (first + pageSize < data.size()) {
            return data.subList(first, first + pageSize);
        }

        return data.subList(first, first + (dataSize % pageSize));
    }

}
