package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class LogYear extends DataUnit {

  public static final String LOGS_PROPERTY = "com.etlsolutions.javafx.data.log.LogYear.LOGS_PROPERTY";
  public static final String YEAR_PROPERTY = "com.etlsolutions.javafx.data.log.LogYear.YEAR_PROPERTY";
  public static final String MONTHS_PROPERTY = "com.etlsolutions.javafx.data.log.LogYear.MONTHS_PROPERTY";

  private int year;
  private List<LogMonth> months;

  public int getYear() {
    return year;
  }

  void setYear(int year) {
    int oldValue = this.year;
    this.year = year;
    setTitle(String.valueOf(year));
    fireChange(YEAR_PROPERTY, oldValue, this.year);
  }

  public List<LogMonth> getMonths() {
    return new ArrayList<>(months);
  }

  void setMonths(List<LogMonth> months) {
    this.months = new ArrayList<>(months);
    fireChange(MONTHS_PROPERTY);
  }

  public LogMonth getMonth(int month) {

    for (LogMonth m : months) {
      if (m.getMonth() == month) {
        return m;
      }
    }
    return null;
  }

  void addMonth(int month) {

    for (LogMonth m : months) {
      if (m.getMonth() == month) {
        return;
      }
    }

    LogMonth l = new LogMonth();
    l.setId(DataUnitIdRegistry.createNewId());
    l.setMonth(month);
    months.add(l);
    fireChange(MONTHS_PROPERTY);
  }

  void removeMonth(int month) {

    LogMonth logMonth = null;

    for (LogMonth m : months) {
      if (m.getMonth() == month) {
        logMonth = m;
      }
    }
    if (logMonth != null) {
      months.remove(logMonth);
      fireChange(MONTHS_PROPERTY);
    }
  }

  boolean addLog(Log log) {
    int month = log.getMonth();
    for (LogMonth l : months) {
      if (l.getMonth() == month) {
        boolean success = l.addLog(log);
        fireChange(LOGS_PROPERTY);
        return success;
      }
    }

    LogMonth logMonth = new LogMonth();
    logMonth.setId(DataUnitIdRegistry.createNewId());
    logMonth.setMonth(month);
    months.add(logMonth);
    boolean success = logMonth.addLog(log);
    fireChange(LOGS_PROPERTY);
    return success;
  }

  boolean removeLog(Log log) {
    for (int i = 0; i< months.size(); i++) {
      LogMonth l = months.get(i);
      if (l.contains(log)) {
        boolean success = l.removeLog(log);
        if(l.isEmpty()) {
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
      if (l.contains(log)) {
        return true;
      }
    }
    return false;
  }

  boolean isEmpty() {
    return months.isEmpty();
  }
}
