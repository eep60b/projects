package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.plantgroup.AddPlantGroupDataModel;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.TreeCellFactory;
import com.etlsolutions.javafx.presentation.view.tree.plant.PlantsGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class LivePlantProjectPropertyChangeAdapter implements PropertyChangeListener {

    private final TreeView<DataUnit> livePlantsTreeView;

    public LivePlantProjectPropertyChangeAdapter(TreeView<DataUnit> livePlantsTreeView) {
        this.livePlantsTreeView = livePlantsTreeView;
    }

    public void process(ProjectContents contents) {

        if (contents == null) {
            livePlantsTreeView.setRoot(null);
            return;
        }
        
        MenuItem plantGroupMenuItem = new MenuItem("New plant group");
        ContextMenu plantGroupContextMenu = new ContextMenu(plantGroupMenuItem);
//        livePlantsTreeView.setContextMenu(new ContextMenu(plantGroupMenuItem));
        plantGroupMenuItem.setOnAction(new ContextMenuEventHandler(plantGroupContextMenu, new FXMLActionEventHandler<>(new AddPlantGroupDataModel())));

        // MenuItem editPlantsGroupMenuItem = new MenuItem("Edit plant group");
        // livePlantsTreeView.getContextMenu().getItems().add(editPlantsGroupMenuItem);
        // editPlantsGroupMenuItem.setOnAction(new FXMLActionEventHandler<>(new EditPlantGroupDataModel()));  
        livePlantsTreeView.setCellFactory(new TreeCellFactory());
        PlantGroupRoot plantGroupRoot = contents.getPlantsGroupRoot();
        MenuedTreeItem plantGroupRootTreeItem = new PlantsGroupRootTreeItem(plantGroupContextMenu, plantGroupRoot);
        livePlantsTreeView.setRoot(plantGroupRootTreeItem);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ProjectContents contents = ((ValueWrapper<ProjectContents>) evt.getSource()).getValue();
        process(contents);
    }

}
