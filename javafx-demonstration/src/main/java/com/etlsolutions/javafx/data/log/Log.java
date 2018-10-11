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

  private LocalDateTime createdTime;
  
  private LocalDateTime modifiedTime;
  
  private LocalDateTime startTime;

    public Log() {
    }

    public Log(String title, String information) {
        super(title, information);
        createdTime = LocalDateTime.now();
        modifiedTime = createdTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
  

  public int getYear() {
    return startTime.getYear();
  }

  public int getMonth() {
    return startTime.getMonth().getValue();
  }
}
