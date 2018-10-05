package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.presentation.tree.area.AreaRootTreeItem;
import com.etlsolutions.javafx.system.ProjectManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class LocationsController implements Initializable {

    @FXML
    private TreeView<DataUnit> locationsTreeView;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AreaRoot r = ProjectManager.getInstance().getProject().getAreaRoot();
        locationsTreeView.setRoot(new AreaRootTreeItem(r));
    }

}
