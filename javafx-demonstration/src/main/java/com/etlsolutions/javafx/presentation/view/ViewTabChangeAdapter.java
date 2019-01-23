package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;

/**
 *
 * @author zc
 */
public class ViewTabChangeAdapter implements ChangeListener<Tab>{

    private final ValueWrapper<DataUnit> dataUnitValueWrapper = ProjectManager.getInstance().getSelectedDataUnitValueWrapper();
    
    @Override
    public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
     
        dataUnitValueWrapper.getValue().removeListeners();
        String id = newValue.getId();
        dataUnitValueWrapper.setValue(ViewTabsManager.getInstance().getTreeViewMap().get(id).getSelectionModel().getSelectedItem().getValue());
    }
}
