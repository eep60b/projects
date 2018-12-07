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

    public PlantsGroupItem(PlantGroup model) {
        super(model);
        List<TreeItem<DataUnit>> children = getChildren();
        for (PlantSubGroup type : model.getPlantsSubGroups()) {
    
                children.add(new PlantsTypeTreeItem(type));
            
        }
    }

}
