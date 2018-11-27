package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingObservationValueWrapper {
    
    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<LocalDateTime> endTimeValueWrapper;

    public GrowingObservationValueWrapper() {
        this.startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        this.endTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
    }

    public GrowingObservationValueWrapper(GrowingObservation growingObservation) {
        this.startTimeValueWrapper = new ValueWrapper<>(growingObservation.getStartTime());
        this.endTimeValueWrapper = new ValueWrapper<>(growingObservation.getEndTime());
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return endTimeValueWrapper;
    }    
}
