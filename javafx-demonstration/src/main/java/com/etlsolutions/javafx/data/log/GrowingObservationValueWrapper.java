package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingObservationValueWrapper extends DataUnitValueWrapper {

    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<LocalDateTime> endTimeValueWrapper;

    public GrowingObservationValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, LocalDateTime endTime) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        startTimeValueWrapper = new ValueWrapper<>(startTime);
        endTimeValueWrapper = new ValueWrapper<>(endTime);
    }


    public GrowingObservationValueWrapper(GrowingObservation growingObservation) {
        super(growingObservation);
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
