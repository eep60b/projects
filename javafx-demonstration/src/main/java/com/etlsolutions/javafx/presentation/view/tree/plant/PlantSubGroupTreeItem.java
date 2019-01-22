package com.etlsolutions.javafx.presentation.view.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.view.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantSubGroupTreeItem extends MenuedTreeItem {
    
    public PlantSubGroupTreeItem(PlantSubGroup model) {
        super(model);
        List<TreeItem<DataUnit>> children = getChildren();
        
        ObservableListWrapperA<Plants> plantsList = model.getPlants();
        
        for (Plants plants : plantsList) {
            children.add(new PlantsTreeItem(plants));
        }
        
        plantsList.addListener(new DataUnitListChangeAdapter<>(children));
    }   
}
