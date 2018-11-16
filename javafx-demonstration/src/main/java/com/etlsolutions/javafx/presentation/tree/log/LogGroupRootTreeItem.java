package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class LogGroupRootTreeItem extends MenuedTreeItem {

    public LogGroupRootTreeItem(LogGroupRoot model) {
        super(model);
        List<TreeItem<DataUnit>> children = getChildren();
        children.add(new LogGroupTreeItem(model.getEvents()));
        children.add(new LogGroupTreeItem(model.getIssues()));
        children.add(new LogGroupTreeItem(model.getNotes()));
        children.add(new LogGroupTreeItem(model.getTasks()));
        children.add(new LogGroupTreeItem(model.getTests()));
        children.add(new LogGroupTreeItem(model.getWeatherRecords()));

    }
}
