package com.etlsolutions.gwise.presentation.view.tree.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.log.GwiseLog;
import com.etlsolutions.gwise.data.log.GwiseLogMonth;
import com.etlsolutions.gwise.presentation.view.tree.GwiseDataUnitTreeItemListChangeAdapter;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.log.LogTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseLogMonthTreeItem extends GwiseMenuedTreeItem {

    public GwiseLogMonthTreeItem(GwiseLogMonth month) {
        super(month);
        List<TreeItem<GwiseDataUnit>> children = getChildren();
        ObservableListWrapperA<GwiseLog> logs = month.getLogs();
        for (GwiseLog log : logs) {
            children.add(new GwiseLogTreeItem(log));
        }
        logs.addListener(new GwiseDataUnitTreeItemListChangeAdapter<>(children));
    }
}
