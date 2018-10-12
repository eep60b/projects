package com.etlsolutions.javafx.presentation.menu.add.growingobservation;

import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class AddGrowingObservationDataModel extends DataUnitFXMLDataModel {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    private GrowingObservation growingObservation;

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
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        growingObservation = LogFactory.createGrowingObservation(title, information, startTime, endTime);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGrowingIssueObservation.fxml";
    }

    public GrowingObservation getGrowingObservation() {
        return growingObservation;
    }
}
