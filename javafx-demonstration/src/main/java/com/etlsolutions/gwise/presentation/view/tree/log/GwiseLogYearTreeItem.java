package com.etlsolutions.gwise.presentation.view.tree.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.log.GwiseLogMonth;
import com.etlsolutions.gwise.data.log.GwiseLogYear;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.log.LogMonthTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseLogYearTreeItem extends GwiseMenuedTreeItem {
    
    public GwiseLogYearTreeItem(GwiseLogYear year) {
        
        super(year);
        List<TreeItem<GwiseDataUnit>> children = getChildren();        
        ObservableListWrapperA<GwiseLogMonth> months = year.getMonths();
        for (GwiseLogMonth month : months) {
            children.add(new GwiseLogMonthTreeItem(month));
        }
        months.addListener(new GwiseDataUnitTreeItemListChangeAdapter<>(children));      
    }    
}
