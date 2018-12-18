package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class LogGroup extends DataUnit {

    @JsonIgnore
    public static final String LOGS_PROPERTY = "com.etlsolutions.javafx.data.log.LogGroup.LOGS_PROPERTY";
    @JsonIgnore
    public static final String YEARS_PROPERTY = "com.etlsolutions.javafx.data.log.LogGroup.YEARS_PROPERTY";
    @JsonIgnore
    private final ObservableListWrapperA<Log> cache = new ObservableListWrapperA<>();

    private ObservableListWrapperA<LogYear> years;

    public LogGroup() {
    }

    protected LogGroup(String title, String information) {
        super(title, information);
        years = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<LogYear> getYears() {
        return years;
    }

    public void setYears(ObservableListWrapperA<LogYear> years) {
        this.years = years;
    }

    public boolean addLog(Log log) {
        int year = log.getYear();
        for (LogYear l : years) {
            if (l.getYear() == year) {
                boolean success = l.addLog(log);
                addLogToCache(log);
                return success;
            }
        }

        LogYear logYear = new LogYear(year);
        years.add(logYear);
        boolean success = logYear.addLog(log);
        addLogToCache(log);
        return success;
    }

    public boolean removeLog(Log log) {

        for (int i = 0; i < years.size(); i++) {
            LogYear l = years.get(i);
            if (l.contains(log)) {
                boolean success = l.removeLog(log);
                if (l.isEmpty()) {
                    years.remove(l);
                }
                removeLogFromCache(log);
                return success;
            }
        }

        return false;
    }

    private void addLogToCache(Log log) {
        cache.add(log);
        fireChange(LOGS_PROPERTY);
    }

    private void removeLogFromCache(Log log) {
        cache.remove(log);
        fireChange(LOGS_PROPERTY);
    }

    @JsonIgnore
    public ObservableListWrapperA<Log> getLogs() {
        return cache;
    }
    
    public void refreshCache() {
        
        cache.clear();
        
        for(LogYear year :years) {
            
            cache.addAll(year.getLogs());
        }
    }
}
