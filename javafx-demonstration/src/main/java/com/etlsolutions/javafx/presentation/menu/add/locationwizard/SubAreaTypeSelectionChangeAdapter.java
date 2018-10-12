package com.etlsolutions.javafx.presentation.menu.add.locationwizard;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
class SubAreaTypeSelectionChangeAdapter implements ChangeListener<SingleSelectionModel<SubAreaType>> {

    private final AddLocationWizardDataModel model;

    public SubAreaTypeSelectionChangeAdapter(AddLocationWizardDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<SubAreaType>> observable, SingleSelectionModel<SubAreaType> oldValue, SingleSelectionModel<SubAreaType> newValue) {
         model.setSelectedSubAreaType(newValue.getSelectedItem());
    }
    
}