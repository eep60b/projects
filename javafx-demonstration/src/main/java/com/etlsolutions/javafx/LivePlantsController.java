package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.plantgroup.AddPlantGroupDataModel;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import com.etlsolutions.javafx.presentation.tree.TreeCellFactory;
import com.etlsolutions.javafx.presentation.tree.plant.PlantsGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import static com.etlsolutions.javafx.system.ProjectManager.PROJECT_PROPERTY;
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

        MenuItem plantGroupMenuItem = new MenuItem("New plant group");
        ContextMenu plantGroupContextMenu = new ContextMenu(plantGroupMenuItem);
//        livePlantsTreeView.setContextMenu(new ContextMenu(plantGroupMenuItem));
        plantGroupMenuItem.setOnAction(new ContextMenuEventHandler(plantGroupContextMenu, new FXMLActionEventHandler<>(new AddPlantGroupDataModel())));

        // MenuItem editPlantsGroupMenuItem = new MenuItem("Edit plant group");
        // livePlantsTreeView.getContextMenu().getItems().add(editPlantsGroupMenuItem);
        // editPlantsGroupMenuItem.setOnAction(new FXMLActionEventHandler<>(new EditPlantGroupDataModel()));  
        livePlantsTreeView.setCellFactory(new TreeCellFactory());

        ProjectManager manager = ProjectManager.getInstance();

        ProjectContents projectContents = manager.getContents();
        PlantGroupRoot plantGroupRoot = projectContents == null ? null : projectContents.getPlantsGroupRoot();
        MenuedTreeItem plantGroupRootTreeItem = new PlantsGroupRootTreeItem(plantGroupContextMenu, plantGroupRoot);
        livePlantsTreeView.setRoot(plantGroupRootTreeItem);
        manager.addPropertyChangeListener(PROJECT_PROPERTY, new ProjectPorpertyChangeAdapter(plantGroupRootTreeItem));
    }
}
