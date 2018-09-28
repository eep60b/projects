package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class LogMonth extends DataUnit {
    
    private int month;
    private ObservableList<Log> logs;

    public LogMonth() {
    }

    protected LogMonth(int month) {
        super(String.valueOf(month), String.valueOf(month));
        logs = FXCollections.observableArrayList();
    }

    public int getMonth() {
        return month;
    }

    public ObservableList<Log> getLogs() {
        return logs;
    }
}
