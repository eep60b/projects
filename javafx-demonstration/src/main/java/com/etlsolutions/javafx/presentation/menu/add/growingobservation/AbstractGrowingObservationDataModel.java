package com.etlsolutions.javafx.presentation.menu.add.growingobservation;

import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingObservationDataModel extends DataUnitFXMLDataModel<GrowingObservation> {

    protected LocalDateTime startTime;
    protected LocalDateTime endTime;

    public AbstractGrowingObservationDataModel() {
    }

    public AbstractGrowingObservationDataModel(GrowingObservation growingObservation) {
        item = growingObservation;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/log/GrowingIssueObservation.fxml";
    }
}
