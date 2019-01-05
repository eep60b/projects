package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
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
        ObservableListWrapperA<PlantSubGroup> subGroups = model.getPlantsSubGroups();
        for (PlantSubGroup subGroup : model.getPlantsSubGroups()) {
    
                children.add(new PlantSubGroupTreeItem(subGroup));            
        }
        
        subGroups.addListener(new DataUnitListChangeAdapter<>(children));
    }

}
