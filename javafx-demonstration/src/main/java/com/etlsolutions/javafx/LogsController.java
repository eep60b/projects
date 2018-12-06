package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.presentation.tree.log.LogGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;

/**
 * The LogsController class is a FXML Controller class to control the view tab
 * of logs.
 *
 * @author zc
 */
public class LogsController extends AbstractFXMLController {

    @FXML
    private TreeView<DataUnit> logsTreeView;

    @Override
    public void initializeComponents() {

        ProjectContents p = ProjectManager.getInstance().getContents();

        if (p == null) {
            return;
        }
        LogGroupRoot r = p.getLogGroupRoot();
        logsTreeView.setRoot(new LogGroupRootTreeItem(r));
    }
}
