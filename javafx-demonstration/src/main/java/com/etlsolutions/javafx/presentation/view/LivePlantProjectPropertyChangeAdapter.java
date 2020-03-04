package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.plantgroup.AddPlantGroupDataModel;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.TreeCellFactory;
import com.etlsolutions.javafx.presentation.view.tree.plant.PlantsGroupRootTreeItem;
import com.etlsolutions.gwise.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;

/**
 * The LivePlantProjectPropertyChangeAdapter class is a property change listener
 * which listens to the change of project itself. When the project changes, the
 * ProjectContents object changes.
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
            livePlantsTreeView.getSelectionModel().clearSelection();
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
        livePlantsTreeView.getSelectionModel().select(plantGroupRootTreeItem);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ProjectContents contents = ((ValueWrapper<ProjectContents>) evt.getSource()).getValue();
        process(contents);
    }

}
