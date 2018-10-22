package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class SubAreaSelectionChangeAdaper implements ChangeListener<SingleSelectionModel<SubArea>> {

    private final AddLocationDataModel model;

    public SubAreaSelectionChangeAdaper(AddLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<SubArea>> observable, SingleSelectionModel<SubArea> oldValue, SingleSelectionModel<SubArea> newValue) {
        model.setSelectedSubArea(newValue.getSelectedItem());
    }
}
