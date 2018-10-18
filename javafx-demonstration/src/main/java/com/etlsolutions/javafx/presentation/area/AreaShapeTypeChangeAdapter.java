package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaShape;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class AreaShapeTypeChangeAdapter implements ChangeListener<SingleSelectionModel<AreaShape>> {

    private final AbstractAreaDataModel model;

    public AreaShapeTypeChangeAdapter(AbstractAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<AreaShape>> observable, SingleSelectionModel<AreaShape> oldValue, SingleSelectionModel<AreaShape> newValue) {
        model.setSelectedAreaShapeType(newValue.getSelectedItem());
    }
    
}