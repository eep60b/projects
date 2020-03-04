package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLogYear extends GwiseDataUnit {

    private final ValueWrapper<Integer> yearWrapper;
    private final ObservableListWrapperA<GwiseLogMonth> months;

    public GwiseLogYear(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, int year, List<GwiseLogMonth> months) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        yearWrapper = new ValueWrapper<>(year);
        this.months = new ObservableListWrapperA<>(months);
    }

    public GwiseLogYear(int year) {
        this(new GwiseLogYearBean(year));
    }
    
    public GwiseLogYear(GwiseLogYearBean bean) {
        super(bean);
        yearWrapper = new ValueWrapper<>(bean.getYear());
        this.months = new ObservableListWrapperA<>();
        for (GwiseLogMonthBean month : bean.getMonths()) {
            months.add(new GwiseLogMonth(month));
        }
    }

    public int getYear() {
        return yearWrapper.getValue();
    }

    public void setYear(int year) {
        yearWrapper.setValue(year);
    }

    public ValueWrapper<Integer> getYearWrapper() {
        return yearWrapper;
    }

    public ObservableListWrapperA<GwiseLogMonth> getMonths() {
        return months;
    }

    public GwiseLogMonth getMonth(int month) {

        for (GwiseLogMonth m : months) {
            if (m.getMonth() == month) {
                return m;
            }
        }
        return null;
    }

    boolean addLog(GwiseLog log) {
        int month = log.getMonth();
        for (GwiseLogMonth l : months) {
            if (l.getMonth() == month) {
                boolean success = l.getLogs().add(log);
                return success;
            }
        }

        GwiseLogMonth logMonth = new GwiseLogMonth(month);
        months.add(logMonth);
        boolean success = logMonth.getLogs().add(log);
        return success;
    }

    boolean removeLog(GwiseLog log) {
        for (int i = 0; i < months.size(); i++) {
            GwiseLogMonth l = months.get(i);
            if (l.getLogs().contains(log)) {
                boolean success = l.getLogs().remove(log);
                if (l.getLogs().isEmpty()) {
                    months.remove(l);
                }
                return success;
            }
        }

        return false;
    }

    public boolean contains(GwiseLog log) {

        for (GwiseLogMonth l : months) {
            if (l.getLogs().contains(log)) {
                return true;
            }
        }
        return false;
    }

    boolean isEmpty() {
        return months.isEmpty();
    }

    public ObservableListWrapperA<GwiseLog> getLogs() {

        ObservableListWrapperA<GwiseLog> logs = new ObservableListWrapperA<>();

        for (GwiseLogMonth month : months) {
            logs.addAll(month.getLogs());
        }

        return logs;
    }

    @Override
    public GwiseLogYearBean getBean() {
        return new GwiseLogYearBean(this);
    }
}
