package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.presentation.tree.log.LogGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;
import org.apache.log4j.Logger;

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

        LogGroupRoot r = ProjectManager.getInstance().getProject().getLogGroupRoot();
        logsTreeView.setRoot(new LogGroupRootTreeItem(r));
    }
}
