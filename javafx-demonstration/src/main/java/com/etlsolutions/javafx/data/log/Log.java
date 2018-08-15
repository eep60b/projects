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
  public static final String TIME_PROPERTY = "com.etlsolutions.javafx.data.log.Log.TIME_PROPERTY";

  private final Calendar calendar = Calendar.getInstance();

  public Date getTime() {
    return calendar.getTime();
  }

  public void setTime(Date time) {
    Date oldValue = calendar.getTime();
    calendar.setTime(time);
    fireChange(TIME_PROPERTY, oldValue, time);
  }

  public int getYear() {
    return calendar.get(Calendar.YEAR);
  }

  public int getMonth() {
    return calendar.get(Calendar.MONTH);
  }

  @Override
  public DataUnit createInitialisedInstance() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
