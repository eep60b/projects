package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.presentation.tree.area.AreaRootTreeItem;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class LocationProjectPropertyChangeAdapter implements PropertyChangeListener {

    private final TreeView<DataUnit> locationsTreeView;

    public LocationProjectPropertyChangeAdapter(TreeView<DataUnit> locationsTreeView) {
        this.locationsTreeView = locationsTreeView;
    }

    public void process(ProjectContents contents) {
        
        if (contents == null) {
            locationsTreeView.setRoot(null);
            return;
        }

        AreaRoot r = contents.getAreaRoot();
        locationsTreeView.setRoot(new AreaRootTreeItem(r));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process(((ValueWrapper<ProjectContents>) evt.getSource()).getValue());
    }
}
