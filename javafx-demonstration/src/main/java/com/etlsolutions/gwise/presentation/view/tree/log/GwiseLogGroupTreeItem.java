package com.etlsolutions.gwise.presentation.view.tree.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.log.GwiseLogGroup;
import com.etlsolutions.gwise.data.log.GwiseLogYear;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseLogGroupTreeItem extends GwiseMenuedTreeItem {

    public GwiseLogGroupTreeItem(GwiseLogGroup group) {
        
        super(group);
        
        List<TreeItem<GwiseDataUnit>> children = getChildren();        
        ObservableListWrapperA<GwiseLogYear> years = group.getYears();
        for (GwiseLogYear year : years) {
            children.add(new GwiseLogYearTreeItem(year));
        }

        years.addListener(new GwiseDataUnitTreeItemListChangeAdapter<>(children));
    }
}
