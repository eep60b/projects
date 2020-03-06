package com.etlsolutions.gwise.presentation.view.tree.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.plant.GwisePlantGroup;
import com.etlsolutions.gwise.data.plant.GwisePlantGroupRoot;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwisePlantGroupRootTreeItem extends GwiseMenuedTreeItem {

   

    public GwisePlantGroupRootTreeItem(ContextMenu contextMenu, GwisePlantGroupRoot model) {
        
        super(contextMenu, model);
        List<TreeItem<GwiseDataUnit>> children = getChildren();
        for (GwisePlantGroup group : model.getPlantGroups()) {
            if (!group.getPlantSubgroups().isEmpty()) {
                children.add(new GwisePlantGroupItem(group));
            }
        }
    }
}
