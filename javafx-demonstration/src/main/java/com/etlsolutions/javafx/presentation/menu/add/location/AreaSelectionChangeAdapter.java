package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class AreaSelectionChangeAdapter implements ChangeListener<SingleSelectionModel<Area>> {

    private final AddLocationWizardDataModel model;

    public AreaSelectionChangeAdapter(AddLocationWizardDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<Area>> observable, SingleSelectionModel<Area> oldValue, SingleSelectionModel<Area> newValue) {
         model.setSelectedArea(newValue.getSelectedItem());
    }
    
}
