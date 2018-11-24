package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingIssueDataModel extends AbstractGrowingIssueDataModel {
    
    public AddGrowingIssueDataModel() {

    }

    @Override
    public void save() {
       dataUnit = LogFactory.getInstance().createGrowingIssue(commonValueWrapper, startTime, endTime, errorMessage, errorMessage);
       ProjectManager.getInstance().getContents().getLogGroupRoot().getIssues().addLog(dataUnit);
    }

    
}
