package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantsGroupRootTreeItem extends MenuedTreeItem {

   

    public PlantsGroupRootTreeItem(ContextMenu contextMenu, PlantGroupRoot model) {
        
        super(contextMenu, model);
        List<TreeItem<DataUnit>> children = getChildren();
        for (PlantGroup group : model.getPlantGroups()) {
            if (!group.getPlantsSubGroups().isEmpty()) {
                children.add(new PlantsGroupItem(group));
            }
        }
    }
}
