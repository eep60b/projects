package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.Date;

/**
 * Example: Events, Tasks, Issues, Tests, Note.
 * @author zc
 */
public class Log extends DataUnit {
  
  private Date time;

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
