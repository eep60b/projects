package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class SubAreaShapeChangeAdapter implements ChangeListener<SingleSelectionModel<SubAreaShape>> {

    private final AbstractSubAreaDataModel model;

    public SubAreaShapeChangeAdapter(AbstractSubAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<SubAreaShape>> observable, SingleSelectionModel<SubAreaShape> oldValue, SingleSelectionModel<SubAreaShape> newValue) {
        model.setSelectedSubAreaShape(newValue.getSelectedItem());
    }

}
