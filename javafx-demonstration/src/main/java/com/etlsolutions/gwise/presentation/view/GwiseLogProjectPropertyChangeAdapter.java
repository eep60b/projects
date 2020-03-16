package com.etlsolutions.gwise.presentation.view;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.GwiseLogGroupRoot;
import com.etlsolutions.gwise.presentation.view.tree.log.GwiseLogGroupRootTreeItem;
import com.etlsolutions.gwise.system.GwiseProjectContents;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class GwiseLogProjectPropertyChangeAdapter implements PropertyChangeListener {

    private final TreeView<GwiseDataUnit> logsTreeView;

    public GwiseLogProjectPropertyChangeAdapter(TreeView<GwiseDataUnit> logsTreeView) {

        this.logsTreeView = logsTreeView;
    }

    public void process(GwiseProjectContents contents) {

        if (contents == null) {
            logsTreeView.setRoot(null);
            return;
        }

        GwiseLogGroupRoot r = contents.getLogGroupRoot();
        logsTreeView.setRoot(new GwiseLogGroupRootTreeItem(r));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process(((ValueWrapper<GwiseProjectContents>) evt.getSource()).getValue());
    }
}
