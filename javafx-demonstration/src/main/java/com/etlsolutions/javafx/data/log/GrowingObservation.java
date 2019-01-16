package com.etlsolutions.javafx.data.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingObservation extends Note {
    
    @JsonIgnore
    public static final String ENDTIME_PROPERTY = "com.etlsolutions.javafx.data.log.GrowingObservation.ENDTIME_PROPERTY";    
    
    private LocalDateTime endTime;

    public GrowingObservation() {
    }

    public GrowingObservation(GrowingObservationValueWrapper growingObservationValueWrapper) {
        super(growingObservationValueWrapper, growingObservationValueWrapper.getStartTimeValueWrapper().getValue());
        this.endTime = growingObservationValueWrapper.getEndTimeValueWrapper().getValue();
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
