package com.etlsolutions.javafx.presentation.log.growingissue;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingIssueValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingIssueDataModel extends DataUnitFXMLDataModel<GrowingIssue> {
    
    protected final GrowingIssueValueWrapper growingIssueValueWrapper;
    
    public AbstractGrowingIssueDataModel() {
        growingIssueValueWrapper = new GrowingIssueValueWrapper();
    }

    public AbstractGrowingIssueDataModel(GrowingIssue issue) {
        super(issue);
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
    
}
