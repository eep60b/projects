package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantsGroupItem extends MenuedTreeItem {

    private final PlantGroup model;

    public PlantsGroupItem(PlantGroup model) {
        super(model);
        this.model = model;
        List<TreeItem<DataUnit>> children = getChildren();
        for (PlantSubGroup type : model.getPlantsSubGroups()) {
            if (!type.getPlantsList().isEmpty()) {
                children.add(new PlantsTypeTreeItem(type));
            }
        }
    }

}
