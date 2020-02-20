package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class LogYear extends DataUnit {

    @JsonIgnore
    public static final String LOGS_PROPERTY = "com.etlsolutions.javafx.data.log.LogYear.LOGS_PROPERTY";

    private int year;
    private ObservableListWrapperA<LogMonth> months;

    public LogYear() {
    }

    protected LogYear(int year) {
        super(String.valueOf(year));
        months = new ObservableListWrapperA<>();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ObservableListWrapperA<LogMonth> getMonths() {
        return months;
    }

    public void setMonths(ObservableListWrapperA<LogMonth> months) {
        this.months = months;
    }

    public LogMonth getMonth(int month) {

        for (LogMonth m : months) {
            if (m.getMonth() == month) {
                return m;
            }
        }
        return null;
    }

    boolean addLog(Log log) {
        int month = log.getMonth();
        for (LogMonth l : months) {
            if (l.getMonth() == month) {
                boolean success = l.getLogs().add(log);
                fireChange(LOGS_PROPERTY);
                return success;
            }
        }

        LogMonth logMonth = new LogMonth(month);
        months.add(logMonth);
        boolean success = logMonth.getLogs().add(log);
        fireChange(LOGS_PROPERTY);
        return success;
    }

    boolean removeLog(Log log) {
        for (int i = 0; i < months.size(); i++) {
            LogMonth l = months.get(i);
            if (l.getLogs().contains(log)) {
                boolean success = l.getLogs().remove(log);
                if (l.getLogs().isEmpty()) {
                    months.remove(l);
                }
                fireChange(LOGS_PROPERTY);
                return success;
            }
        }

        return false;
    }

    public boolean contains(Log log) {

        for (LogMonth l : months) {
            if (l.getLogs().contains(log)) {
                return true;
            }
        }
        return false;
    }

    boolean isEmpty() {
        return months.isEmpty();
    }
    
    @JsonIgnore
    public ObservableListWrapperA<Log> getLogs() {
        
        ObservableListWrapperA<Log> logs = new ObservableListWrapperA<Log>();
        
        for(LogMonth month : months) {
            logs.addAll(month.getLogs());
        }
        
        return logs;
    }
}
