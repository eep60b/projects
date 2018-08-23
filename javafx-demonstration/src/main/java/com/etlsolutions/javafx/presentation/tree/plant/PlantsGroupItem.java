package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantsGroup;
import com.etlsolutions.javafx.data.plant.PlantsType;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantsGroupItem extends TreeItem<DataUnit> {

    private final PlantsGroup model;

    public PlantsGroupItem(PlantsGroup model) {
        super(model);
        this.model = model;
        List<TreeItem<DataUnit>> children = getChildren();
        for (PlantsType type : model.getPlantsTypes()) {
            if (!type.getPlantses().isEmpty()) {
                children.add(new PlantsTypeTreeItem(type));
            }
        }
    }

}
