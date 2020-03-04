package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
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
public class SelectedItemChangeAdapter implements ChangeListener<TreeItem<DataUnit>> {

    public SelectedItemChangeAdapter() {
    }

    @Override
    public void changed(ObservableValue<? extends TreeItem<DataUnit>> observable, TreeItem<DataUnit> oldValue, TreeItem<DataUnit> newValue) {
        ProjectManager.getInstance().getSelectedDataUnitValueWrapper().setValue(newValue.getValue());
    }
}
