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
public class LocationsController extends AbstractFXMLController {

    @FXML
    private TreeView<DataUnit> locationsTreeView;

    @Override
    public void initializeComponents() {
        
        AreaRoot r = ProjectManager.getInstance().getProject().getAreaRoot();
        locationsTreeView.setRoot(new AreaRootTreeItem(r));
    }
}
