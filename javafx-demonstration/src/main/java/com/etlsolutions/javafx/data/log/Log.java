package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Calendar;
import java.util.Date;

/**
 * Example: Events, Tasks, Issues, Tests, Note.
 *
 * @author zc
 */
public class Log extends DataUnit {

  @JsonIgnore
  public static final String MODIFIED_TIME_PROPERTY = "com.etlsolutions.javafx.data.log.Log.MODIFIED_TIME_PROPERTY";

  private final Calendar createdTime = Calendar.getInstance();
  
  private final Calendar modifiedTime = Calendar.getInstance();
  
  public Date getCreatedTime() {
    return createdTime.getTime();
}
  
  public Date getModifiedTime() {
    return modifiedTime.getTime();
  }

  public void setModifiedTime(Date time) {
    Date oldValue = modifiedTime.getTime();
    modifiedTime.setTime(time);
    fireChange(MODIFIED_TIME_PROPERTY, oldValue, time);
  }

  public int getYear() {
    return modifiedTime.get(Calendar.YEAR);
  }

  public int getMonth() {
    return modifiedTime.get(Calendar.MONTH);
  }
}
