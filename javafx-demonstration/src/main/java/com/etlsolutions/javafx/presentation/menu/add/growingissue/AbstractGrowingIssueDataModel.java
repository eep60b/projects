package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.system.ProjectManager;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingIssueDataModel extends DataUnitFXMLDataModel<GrowingIssue> {

    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected final ValueWrapper<String> solutionValueWrapper;    
    protected final ValueWrapper<String> effectivenessValueWrapper;
    
    public AbstractGrowingIssueDataModel() {
        startTime = LocalDateTime.now();
        endTime = LocalDateTime.now();
        solutionValueWrapper = new ValueWrapper<>("");
        effectivenessValueWrapper = new ValueWrapper<>("");
    }

    public AbstractGrowingIssueDataModel(GrowingIssue issue) {
        super(issue);
        startTime = issue.getStartTime();
        endTime = issue.getEndTime();
        solutionValueWrapper = new ValueWrapper<>(issue.getSolution());
        effectivenessValueWrapper = new ValueWrapper<>(issue.getEffectiveness());
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

    public ValueWrapper<String> getSolutionValueWrapper() {
        return solutionValueWrapper;
    }

    public ValueWrapper<String> getEffectivenessValueWrapper() {
        return effectivenessValueWrapper;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGrowingIssueFXML.fxml";
    }
    
}
