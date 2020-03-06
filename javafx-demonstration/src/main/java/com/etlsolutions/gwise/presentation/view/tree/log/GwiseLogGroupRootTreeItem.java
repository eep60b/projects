package com.etlsolutions.gwise.presentation.view.tree.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.log.GwiseLogGroupRoot;
import com.etlsolutions.gwise.presentation.view.tree.GwiseMenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseLogGroupRootTreeItem extends GwiseMenuedTreeItem {

    public GwiseLogGroupRootTreeItem(GwiseLogGroupRoot model) {
        super(model);
        List<TreeItem<GwiseDataUnit>> children = getChildren();
        children.add(new GwiseLogGroupTreeItem(model.getGvents()));
        children.add(new GwiseLogGroupTreeItem(model.getIssues()));
        children.add(new GwiseLogGroupTreeItem(model.getNotes()));
        children.add(new GwiseLogGroupTreeItem(model.getTasks()));
        children.add(new GwiseLogGroupTreeItem(model.getTests()));
        children.add(new GwiseLogGroupTreeItem(model.getWeatherRecords()));

    }
}
