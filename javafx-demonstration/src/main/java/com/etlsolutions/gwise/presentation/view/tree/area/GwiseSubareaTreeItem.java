package com.etlsolutions.gwise.presentation.view.tree.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.locations.GwiseLocationSet;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseSubareaTreeItem extends GwiseMenuedTreeItem {

    public GwiseSubareaTreeItem(GwiseSubarea subArea) {
        
        super(subArea);
        List<TreeItem<GwiseDataUnit>> children = getChildren();
        ObservableListWrapperA<GwiseLocationSet> locations = subArea.getLocationSets();
        
        for(GwiseLocationSet location : locations) {
            children.add(new LocationSetTreeItem(location));
        }
        
        locations.addListener(new GwiseDataUnitTreeItemListChangeAdapter<>(children));        
        
    }
    
}
