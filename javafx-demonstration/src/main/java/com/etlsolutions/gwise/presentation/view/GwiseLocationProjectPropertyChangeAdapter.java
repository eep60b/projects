package com.etlsolutions.gwise.presentation.view;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.area.GwiseAreaRoot;
import com.etlsolutions.gwise.presentation.view.tree.area.GwiseAreaRootTreeItem;
import com.etlsolutions.gwise.system.GwiseProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class GwiseLocationProjectPropertyChangeAdapter implements PropertyChangeListener {

    private final TreeView<GwiseDataUnit> locationsTreeView;

    public GwiseLocationProjectPropertyChangeAdapter(TreeView<GwiseDataUnit> locationsTreeView) {
        this.locationsTreeView = locationsTreeView;
    }

    public void process(GwiseProjectContents contents) {
        
        if (contents == null) {
            locationsTreeView.setRoot(null);
            return;
        }

        GwiseAreaRoot r = contents.getAreaRoot();
        locationsTreeView.setRoot(new GwiseAreaRootTreeItem(r));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process(((ValueWrapper<GwiseProjectContents>) evt.getSource()).getValue());
    }
}
