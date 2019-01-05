package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class LogMonth extends DataUnit {
    
    private int month;
    private ObservableListWrapperA<Log> logs;

    public LogMonth() {
    }

    protected LogMonth(int month) {
        super(String.valueOf(month));
        logs = new ObservableListWrapperA<>();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public ObservableListWrapperA<Log> getLogs() {
        return logs;
    }

    public void setLogs(ObservableListWrapperA<Log> logs) {
        this.logs = logs;
    }    
}
