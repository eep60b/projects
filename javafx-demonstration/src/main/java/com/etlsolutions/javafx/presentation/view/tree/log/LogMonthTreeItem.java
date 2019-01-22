package com.etlsolutions.javafx.presentation.view.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.LogMonth;
import com.etlsolutions.javafx.presentation.view.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class LogMonthTreeItem extends MenuedTreeItem {

    public LogMonthTreeItem(LogMonth month) {
        super(month);
        List<TreeItem<DataUnit>> children = getChildren();
        ObservableListWrapperA<Log> logs = month.getLogs();
        for (Log log : logs) {
            children.add(new LogTreeItem(log));
        }
        logs.addListener(new DataUnitListChangeAdapter<>(children));
    }
}
