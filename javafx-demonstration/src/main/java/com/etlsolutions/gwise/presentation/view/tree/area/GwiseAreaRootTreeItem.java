package com.etlsolutions.gwise.presentation.view.tree.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.area.GwiseAreaRoot;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseAreaRootTreeItem extends GwiseMenuedTreeItem {

    public GwiseAreaRootTreeItem(GwiseAreaRoot root) {

        super(root);

        List<TreeItem<GwiseDataUnit>> children = getChildren();

        ObservableListWrapperA<GwiseArea> areas = root.getAreas();
        
        for (GwiseArea area : areas) {
                children.add(new GwiseAreaTreeItem(area));
        }
        
        areas.addListener(new GwiseDataUnitTreeItemListChangeAdapter<GwiseArea>(children));
    }
}
