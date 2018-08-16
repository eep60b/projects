package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class LogMonth extends DataUnit {

  @JsonIgnore
  public static final String MONTH_PROPERTY = "com.etlsolutions.javafx.data.log.LogMonth.MONTH_PROPERTY";
  @JsonIgnore
  public static final String LOGS_PROPERTY = "com.etlsolutions.javafx.data.log.LogMonth.LOGS_PROPERTY";
  
  private int month;
  private List<Log> logs = new ArrayList<>();

  public int getMonth() {
    return month;
  }

  void setMonth(int month) {
    int oldValue = this.month;
    this.month = month;
    fireChange(MONTH_PROPERTY, oldValue, this.month);
  }

  public List<Log> getLogs() {
    return new ArrayList<>(logs);
  }

  void setLogs(List<Log> logs) {
    this.logs = new ArrayList<>(logs);
    fireChange(LOGS_PROPERTY);
  }

  boolean addLog(Log log) {
    if (log == null) {
      return false;
    }

    boolean success = logs.add(log);
    fireChange(LOGS_PROPERTY, false, success);
    return success;
  }

  boolean removeLog(Log log) {

    if (log == null) {
      return false;
    }

    boolean success = logs.remove(log);
    fireChange(LOGS_PROPERTY, false, success);
    return success;
  }

  boolean contains(Log log) {
    return logs.contains(log);
  }

  boolean isEmpty() {
    return logs.isEmpty();
  }
}
