package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantsTypeTreeItem extends MenuedTreeItem {
    
    public PlantsTypeTreeItem(PlantSubGroup model) {
        super(model);
        List<TreeItem<DataUnit>> children = getChildren();
        for (Plants plants : model.getPlantsList()) {
            children.add(new PlantsTreeItem(plants));
        }
    }   
}
