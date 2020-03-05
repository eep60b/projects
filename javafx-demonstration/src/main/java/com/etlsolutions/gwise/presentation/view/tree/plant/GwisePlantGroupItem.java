package com.etlsolutions.gwise.presentation.view.tree.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.plant.GwisePlantGroup;
import com.etlsolutions.gwise.data.plant.GwisePlantSubgroup;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwisePlantGroupItem extends GwiseMenuedTreeItem {

    public GwisePlantGroupItem(GwisePlantGroup model) {
        
        super(model);
        List<TreeItem<GwiseDataUnit>> children = getChildren();
        ObservableListWrapperA<GwisePlantSubgroup> subGroups = model.getPlantSubgroups();
        for (GwisePlantSubgroup subgroup : model.getPlantSubgroups()) {
    
                children.add(new GwisePlantSubgroupTreeItem(subgroup));            
        }
        
        subGroups.addListener(new GwiseDataUnitTreeItemListChangeAdapter<>(children));
    }

}
