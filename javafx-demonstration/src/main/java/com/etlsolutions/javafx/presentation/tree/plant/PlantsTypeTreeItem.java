package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantType;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantsTypeTreeItem extends TreeItem<DataUnit> {
    
    private final PlantType model;
    
    public PlantsTypeTreeItem(PlantType model) {
        super(model);
        this.model = model;
        List<TreeItem<DataUnit>> children = getChildren();
        for (Plants plants : model.getPlantsList()) {
            children.add(new PlantsTreeItem(plants));
        }
    }
    
}
