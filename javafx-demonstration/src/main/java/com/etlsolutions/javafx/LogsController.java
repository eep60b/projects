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

/**
 * The LogsController class is a FXML Controller class to control the view tab of logs.
 *
 * @author zc
 */
public class LogsController implements Initializable {

    @FXML
    private TreeView<DataUnit> logsTreeView;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        LogGroupRoot r = ProjectManager.getInstance().getProject().getLogGroupRoot();
        
        
        
        
       logsTreeView.setRoot(new LogGroupRootTreeItem(r));
    }

}
