package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaShapeType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class AreaShapeTypeChangeAdapter implements ChangeListener<SingleSelectionModel<AreaShapeType>> {

    private final AbstractAreaDataModel model;

    public AreaShapeTypeChangeAdapter(AbstractAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<AreaShapeType>> observable, SingleSelectionModel<AreaShapeType> oldValue, SingleSelectionModel<AreaShapeType> newValue) {
        model.setSelectedAreaShapeType(newValue.getSelectedItem());
    }
    
}