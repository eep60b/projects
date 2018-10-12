package com.etlsolutions.javafx.data.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingObservation extends Log {
    
    @JsonIgnore
    public static final String ENDTIME_PROPERTY = "com.etlsolutions.javafx.data.log.GrowingObservation.ENDTIME_PROPERTY";    
    
    private LocalDateTime endTime;

    public GrowingObservation() {
    }

    public GrowingObservation(String title, String information, LocalDateTime startTime, LocalDateTime endTime) {
        super(title, information, startTime);
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        LocalDateTime oldValue = this.endTime;
        this.endTime = endTime;
        support.fireChange(ENDTIME_PROPERTY, oldValue, this.endTime);
    } 
}
