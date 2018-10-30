package com.etlsolutions.javafx.presentation.menu.add.growingobservation;

import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingObservationDataModel extends DataUnitFXMLDataModel {

    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    
    protected GrowingObservation growingObservation;

    public AbstractGrowingObservationDataModel() {
    }

    public AbstractGrowingObservationDataModel(GrowingObservation growingObservation) {
        this.growingObservation = growingObservation;
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

    public GrowingObservation getGrowingObservation() {
        return growingObservation;
    }
}
