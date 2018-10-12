package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

/**
 * Example: Events, Tasks, Issues, Tests, Note.
 *
 * @author zc
 */
public class Log extends DataUnit {

  @JsonIgnore
  public static final String MODIFIED_TIME_PROPERTY = "com.etlsolutions.javafx.data.log.Log.MODIFIED_TIME_PROPERTY";
  @JsonIgnore
  public static final String STARTTIME_PROPERTY = "com.etlsolutions.javafx.data.log.Log.STARTTIME_PROPERTY";

  private final LocalDateTime createdTime;
  
  private LocalDateTime modifiedTime;
  
  private LocalDateTime startTime;

    public Log() {
        createdTime = LocalDateTime.now();
    }

    public Log(String title, String information, LocalDateTime startTime) {
        super(title, information);
        createdTime = LocalDateTime.now();
        modifiedTime = createdTime;
        this.startTime = startTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        LocalDateTime oldValue = this.modifiedTime;
        this.modifiedTime = modifiedTime;
        support.fireChange(MODIFIED_TIME_PROPERTY, oldValue, this.modifiedTime);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        LocalDateTime oldValue = this.startTime;
        this.startTime = startTime;
        support.fireChange(STARTTIME_PROPERTY, oldValue, this.startTime);
    }
  

  public int getYear() {
    return startTime.getYear();
  }

  public int getMonth() {
    return startTime.getMonth().getValue();
  }
}
