package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
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

    private LocalDateTime createdTime;

    private LocalDateTime modifiedTime;

    private LocalDateTime startTime;

    public Log() {

    }

    public Log(DataUnitValueWrapper valueWrapper, LocalDateTime startTime) {
        super(valueWrapper);
        modifiedTime = createdTime = LocalDateTime.now();
        this.startTime = startTime;
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
    
    @JsonIgnore
    public int getYear() {
        return startTime.getYear();
    }
    
    @JsonIgnore
    public int getMonth() {
        return startTime.getMonth().getValue();
    }
    
}
