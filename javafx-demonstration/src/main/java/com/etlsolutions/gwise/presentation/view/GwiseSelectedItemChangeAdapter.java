package com.etlsolutions.gwise.presentation.view;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.system.ProjectManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;

/**
 * The SelectedItemChangeAdapter class listens to the selection change of tree
 * item.
 *
 * @author zc
 */
public class GwiseSelectedItemChangeAdapter implements ChangeListener<TreeItem<GwiseDataUnit>> {

    public GwiseSelectedItemChangeAdapter() {
    }

    @Override
    public void changed(ObservableValue<? extends TreeItem<GwiseDataUnit>> observable, TreeItem<GwiseDataUnit> oldValue, TreeItem<GwiseDataUnit> newValue) {
        ProjectManager.getInstance().getSelectedGwiseDataUnitValueWrapper().setValue(newValue.getValue());
    }
}
