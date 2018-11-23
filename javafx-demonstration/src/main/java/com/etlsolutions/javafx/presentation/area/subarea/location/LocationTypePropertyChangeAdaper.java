package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    private final NodeGenerator nodeGenerator;

    public LocationTypePropertyChangeAdaper(AbstractLocationDataModel model, Button okButton, Label errorMessageLabel, Tab measurementTab, NodeGenerator nodeGenerator) {
        this.model = model;
        this.okButton = okButton;
        this.errorMessageLabel = errorMessageLabel;
        this.measurementTab = measurementTab;
        this.nodeGenerator = nodeGenerator;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        okButton.setDisable(!model.isInvalid());
        errorMessageLabel.setDisable(!model.isInvalid());
        errorMessageLabel.setText(model.getErrorMessage());
        measurementTab.setContent(nodeGenerator.getNode((LocationMeasurementType)model.getMeasurementDataModelValueWrapper().getValue().getTypeValueWrapper().getValue()));
    }

}
