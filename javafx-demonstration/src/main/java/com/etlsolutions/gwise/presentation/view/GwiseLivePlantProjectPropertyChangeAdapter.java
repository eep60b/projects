package com.etlsolutions.gwise.presentation.view;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.plant.GwisePlantGroupRoot;
import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.GwiseTreeCellFactory;
import com.etlsolutions.gwise.presentation.view.tree.plant.GwisePlantGroupRootTreeItem;
import com.etlsolutions.gwise.system.GwiseProjectContents;
import com.etlsolutions.javafx.presentation.dialog.plantgroup.AddPlantGroupDataModel;
import com.etlsolutions.javafx.presentation.view.ContextMenuEventHandler;
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
public class GwiseLivePlantProjectPropertyChangeAdapter implements PropertyChangeListener {

    private final TreeView<GwiseDataUnit> livePlantsTreeView;

    public GwiseLivePlantProjectPropertyChangeAdapter(TreeView<GwiseDataUnit> livePlantsTreeView) {
        this.livePlantsTreeView = livePlantsTreeView;
    }

    public void process(GwiseProjectContents contents) {

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
        livePlantsTreeView.setCellFactory(new GwiseTreeCellFactory());
        GwisePlantGroupRoot plantGroupRoot = contents.getPlantsGroupRoot();
        GwiseMenuedTreeItem plantGroupRootTreeItem = new GwisePlantGroupRootTreeItem(plantGroupContextMenu, plantGroupRoot);
        livePlantsTreeView.setRoot(plantGroupRootTreeItem);
        livePlantsTreeView.getSelectionModel().select(plantGroupRootTreeItem);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        GwiseProjectContents contents = ((ValueWrapper<GwiseProjectContents>) evt.getSource()).getValue();
        process(contents);
    }

}
