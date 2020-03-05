package com.etlsolutions.gwise.presentation.view.tree.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.plant.GwiseLocationPlantSet;
import com.etlsolutions.gwise.data.plant.GwisePlantSubgroup;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwisePlantSubgroupTreeItem extends GwiseMenuedTreeItem {
    
    public GwisePlantSubgroupTreeItem(GwisePlantSubgroup model) {
        super(model);
        List<TreeItem<GwiseDataUnit>> children = getChildren();
        
        ObservableListWrapperA<GwiseLocationPlantSet> plantsList = model.getPlantSets();
        
        for (GwiseLocationPlantSet plants : plantsList) {
            children.add(new LocationPlantSetTreeItem(plants));
        }
        
        plantsList.addListener(new GwiseDataUnitTreeItemListChangeAdapter<>(children));
    }   
}
