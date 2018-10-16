package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.etlsolutions.javafx.presentation.tree.plant.PlantsGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class LivePlantsController extends AbstractFXMLController {

    @FXML
    private TreeView<DataUnit> livePlantsTreeView;

    @Override
    public void initializeComponents() {
        
        PlantGroupRoot r = ProjectManager.getInstance().getProject().getPlantsGroupRoot();       
        livePlantsTreeView.setRoot(new PlantsGroupRootTreeItem(r));
        MenuItem createPlantsGroupMenuItem = new MenuItem("New Group");   
        livePlantsTreeView.setContextMenu(new ContextMenu(createPlantsGroupMenuItem));
    }
}
