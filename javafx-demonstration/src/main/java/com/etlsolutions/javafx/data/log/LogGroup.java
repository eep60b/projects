package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

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
  private  final List<Log> cache = new ArrayList<>();
  
  private  List<LogYear> years;

  public List<LogYear> getYears() {
    return new ArrayList<>(years);
  }

    public void setYears(List<LogYear> years) {
        this.years = new ArrayList<>(years);
        for(LogYear year : this.years) {
            addYear(year);
        }
        
        fireChange(YEARS_PROPERTY);
    }
    
    public boolean addYear(LogYear year) {
        boolean success = years.add(year);
        if(success) {
            for (LogMonth month : year.getMonths()) {
                cache.addAll(month.getLogs());
            }
        }
        
        fireChange(YEARS_PROPERTY, false, success);
        return success;
    }
    
    public boolean removeYear(LogYear year) {
        boolean success = years.remove(year);
        fireChange(YEARS_PROPERTY, false, success);
        return success;
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

    LogYear logYear = new LogYear();
    logYear.setId(DataUnitIdRegistry.createNewId());
    logYear.setYear(year);
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

  public List<Log> getLogs() {
    return new ArrayList<>(cache);
  }
}
