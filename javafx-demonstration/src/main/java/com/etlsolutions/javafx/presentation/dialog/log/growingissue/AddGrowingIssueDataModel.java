package com.etlsolutions.javafx.presentation.dialog.log.growingissue;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.gwise.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingIssueDataModel extends AbstractGrowingIssueDataModel {

    @Override
    public void save() {
       set(LogFactory.getInstance().createGrowingIssue(getValueWrapper()));
       ProjectManager.getInstance().getContents().getLogGroupRoot().getIssues().addLog(getItem());
    }
}
