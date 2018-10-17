package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author Zhipeng
 */
public class AreaTypeChangeAdapter implements ChangeListener<SingleSelectionModel<AreaType>> {

    private final AbstractAreaDataModel model;

    public AreaTypeChangeAdapter(AbstractAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<AreaType>> observable, SingleSelectionModel<AreaType> oldValue, SingleSelectionModel<AreaType> newValue) {
        model.setSelectedAreaType(newValue.getSelectedItem());
    }
    
}
