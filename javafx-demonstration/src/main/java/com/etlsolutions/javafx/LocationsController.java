package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.presentation.tree.area.AreaRootTreeItem;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class for the location view.
 *
 * @author zc
 */
public class LocationsController extends AbstractFXMLController {

    @FXML
    private TreeView<DataUnit> locationsTreeView;

    @Override
    public void initializeComponents() {
        
        ProjectContents p = ProjectManager.getInstance().getContents();
        
        if(p == null) {
            return;
        }
       
        AreaRoot r = p.getAreaRoot();
        locationsTreeView.setRoot(new AreaRootTreeItem(r));
    }
}
