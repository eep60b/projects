package com.etlsolutions.gwise.presentation.view.tree.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseAreaTreeItem extends GwiseMenuedTreeItem {

    public GwiseAreaTreeItem(GwiseArea area) {

        super(area);
        List<TreeItem<GwiseDataUnit>> children = getChildren();
        ObservableListWrapperA<GwiseSubarea> subAreas = area.getSubareas();
        
        for(GwiseSubarea subarea : subAreas) {
            children.add(new GwiseSubareaTreeItem(subarea));
        }

        subAreas.addListener(new GwiseDataUnitTreeItemListChangeAdapter<>(children));
    }
}
