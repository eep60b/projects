package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.etlsolutions.javafx.presentation.tree.plant.PlantsGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class LivePlantsController implements Initializable {

    @FXML
    private TreeView<DataUnit> livePlantsTreeView;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PlantGroupRoot r = ProjectManager.getInstance().getProject().getPlantsGroupRoot();
       
        livePlantsTreeView.setRoot(new PlantsGroupRootTreeItem(r));
        MenuItem createPlantsGroupMenuItem = new MenuItem("New Group");
        
        livePlantsTreeView.setContextMenu(new ContextMenu(createPlantsGroupMenuItem));
    }
}
