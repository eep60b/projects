package com.etlsolutions.javafx.presentation.view.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.view.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantGroupItem extends MenuedTreeItem {

    public PlantGroupItem(PlantGroup model) {
        
        super(model);
        List<TreeItem<DataUnit>> children = getChildren();
        ObservableListWrapperA<PlantSubGroup> subGroups = model.getPlantSubGroups();
        for (PlantSubGroup subGroup : model.getPlantSubGroups()) {
    
                children.add(new PlantSubGroupTreeItem(subGroup));            
        }
        
        subGroups.addListener(new DataUnitListChangeAdapter<>(children));
    }

}
