package com.etlsolutions.javafx.presentation.dialog.log.growingissue;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingIssueValueWrapper;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingIssueDataModel extends DataUnitFXMLDataModel<GrowingIssue> {
    
    protected final GrowingIssueValueWrapper growingIssueValueWrapper;
    
    public AbstractGrowingIssueDataModel() {
        growingIssueValueWrapper = LogFactory.getInstance().createDefaultGrowingIssueValueWrapper();
    }

    public AbstractGrowingIssueDataModel(GrowingIssue issue) {
        set(issue);
        growingIssueValueWrapper = new GrowingIssueValueWrapper(issue);
    }    

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return growingIssueValueWrapper.getStartTimeValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return growingIssueValueWrapper.getEndTimeValueWrapper();
    }

    public ValueWrapper<String> getSolutionValueWrapper() {
        return growingIssueValueWrapper.getSolutionValueWrapper();
    }

    public ValueWrapper<String> getEffectivenessValueWrapper() {
        return growingIssueValueWrapper.getEffectivenessValueWrapper();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/GrowingIssueFXML.fxml";
    }

    @Override
    protected GrowingIssueValueWrapper getValueWrapper() {
        return growingIssueValueWrapper;
    }
    
}
