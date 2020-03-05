package com.etlsolutions.gwise.presentation.view.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.log.LogGroupTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseLogGroupRootTreeItem extends MenuedTreeItem {

    public GwiseLogGroupRootTreeItem(LogGroupRoot model) {
        super(model);
        List<TreeItem<DataUnit>> children = getChildren();
        children.add(new LogGroupTreeItem(model.getGvents()));
        children.add(new LogGroupTreeItem(model.getIssues()));
        children.add(new LogGroupTreeItem(model.getNotes()));
        children.add(new LogGroupTreeItem(model.getTasks()));
        children.add(new LogGroupTreeItem(model.getTests()));
        children.add(new LogGroupTreeItem(model.getWeatherRecords()));

    }
}
