package com.etlsolutions.javafx.presentation.log.growingissue;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingIssueDataModel extends AbstractGrowingIssueDataModel {

    @Override
    public void save() {
       set(LogFactory.getInstance().createGrowingIssue(commonValueWrapper, growingIssueValueWrapper));
       ProjectManager.getInstance().getContents().getLogGroupRoot().getIssues().addLog(get());
    }
}
