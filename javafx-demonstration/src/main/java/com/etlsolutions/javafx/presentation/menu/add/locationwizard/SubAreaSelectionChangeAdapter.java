package com.etlsolutions.javafx.presentation.menu.add.locationwizard;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
class SubAreaSelectionChangeAdapter implements ChangeListener<SingleSelectionModel<SubArea>> {

    private final AddLocationWizardDataModel model;

    public SubAreaSelectionChangeAdapter(AddLocationWizardDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<SubArea>> observable, SingleSelectionModel<SubArea> oldValue, SingleSelectionModel<SubArea> newValue) {
         model.setSelectedSubArea(newValue.getSelectedItem());
    }
    
}