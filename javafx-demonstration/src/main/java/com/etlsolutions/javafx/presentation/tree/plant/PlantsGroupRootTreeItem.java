package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantsGroupRoot;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantsGroupRootTreeItem extends TreeItem<DataUnit> {

    public final PlantsGroupRoot model;

    public PlantsGroupRootTreeItem(PlantsGroupRoot model) {
        super(model);
        this.model = model;
        List<TreeItem<DataUnit>> children = getChildren();
        for (PlantGroup group : model.getPlantGroups()) {
            if (!group.getPlantsTypes().isEmpty()) {
                children.add(new PlantsGroupItem(group));
            }
        }
    }
}
