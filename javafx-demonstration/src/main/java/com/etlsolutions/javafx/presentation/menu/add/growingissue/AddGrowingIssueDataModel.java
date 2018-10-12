package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class AddGrowingIssueDataModel extends DataUnitFXMLDataModel {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String solution;    
    private String effectiveness;
    
    public AddGrowingIssueDataModel() {
        startTime = LocalDateTime.now();
        solution = "";
        effectiveness = "";
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

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }
    
    public GrowingIssue getGrowingIssue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGrowingIssueFXML.fxml";
    }
    
}
