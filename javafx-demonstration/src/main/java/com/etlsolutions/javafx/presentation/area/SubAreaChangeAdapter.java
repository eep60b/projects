package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;

/**
 *
 * @author Zhipeng
 */
public class SubAreaChangeAdapter implements ChangeListener<SubArea> {

    private final AbstractAreaDataModel model;
    private final Button removeSubAreaButton;
    private final Button editSubAreaButton;

    public SubAreaChangeAdapter(AbstractAreaDataModel model, Button removeSubAreaButton, Button editSubAreaButton) {
        this.model = model;
        this.removeSubAreaButton = removeSubAreaButton;
        this.editSubAreaButton = editSubAreaButton;
    }

    @Override
    public void changed(ObservableValue<? extends SubArea> observable, SubArea oldValue, SubArea newValue) {
        model.setSelectedSubArea(newValue);
        removeSubAreaButton.setDisable(newValue == null);
        editSubAreaButton.setDisable(newValue == null);
    }
    
}
