package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class LogGroupRootTreeItem extends TreeItem<DataUnit> {

    public LogGroupRootTreeItem(LogGroupRoot value) {
        super(value);
        List<TreeItem<DataUnit>> children = getChildren();
        children.add(new LogGroupTreeItem(value.getEvents()));
        children.add(new LogGroupTreeItem(value.getIssues()));
        children.add(new LogGroupTreeItem(value.getNotes()));
        children.add(new LogGroupTreeItem(value.getTasks()));
        children.add(new LogGroupTreeItem(value.getTests()));
        children.add(new LogGroupTreeItem(value.getWeatherRecords()));

    }
}
