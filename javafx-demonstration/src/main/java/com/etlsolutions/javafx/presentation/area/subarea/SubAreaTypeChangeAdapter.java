package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class SubAreaTypeChangeAdapter implements ChangeListener<SingleSelectionModel<SubAreaType>> {

    private final AbstractSubAreaDataModel model;

    public SubAreaTypeChangeAdapter(AbstractSubAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<SubAreaType>> observable, SingleSelectionModel<SubAreaType> oldValue, SingleSelectionModel<SubAreaType> newValue) {
        model.setSelectedSubAreaType(newValue.getSelectedItem());
    }

}
