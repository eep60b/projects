package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.presentation.view.tree.log.LogGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class LogProjectPropertyChangeAdapter implements PropertyChangeListener {

    private final TreeView<DataUnit> logsTreeView;

    public LogProjectPropertyChangeAdapter(TreeView<DataUnit> logsTreeView) {

        this.logsTreeView = logsTreeView;
    }

    public void process(ProjectContents contents) {

        if (contents == null) {
            logsTreeView.setRoot(null);
            return;
        }

        LogGroupRoot r = contents.getLogGroupRoot();
        logsTreeView.setRoot(new LogGroupRootTreeItem(r));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process(((ValueWrapper<ProjectContents>) evt.getSource()).getValue());
    }
}
