package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddVarietyAliasDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

/**
 *
 * @author zc
 */
public class LocationTypePropertyChangeAdaper implements PropertyChangeListener {

    private final AbstractLocationDataModel model;
    private final Button okButton;
    private final Label errorMessageLabel;
    private final Tab measurementTab;
    private final Map<LocationMeasurementType, Node> map;

    public LocationTypePropertyChangeAdaper(AbstractLocationDataModel model, Button okButton, Label errorMessageLabel, Tab measurementTab, Map<LocationMeasurementType, Node> map) {
        this.model = model;
        this.okButton = okButton;
        this.errorMessageLabel = errorMessageLabel;
        this.measurementTab = measurementTab;
        this.map = map;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        okButton.setDisable(!model.isInvalid());
        errorMessageLabel.setDisable(!model.isInvalid());
        errorMessageLabel.setText(model.getErrorMessage());
        measurementTab.setContent(map.get(model.getMeasurementDataModel().getType()));
    }

}
