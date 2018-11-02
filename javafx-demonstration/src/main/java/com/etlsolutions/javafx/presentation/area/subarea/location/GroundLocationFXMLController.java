package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author zc
 */
public class GroundLocationFXMLController extends AbstractComponentsFXMLController<GroundLocationMeasurementDataModel> {

    @FXML
    private ComboBox<String> referencePointComboBox;

    @FXML
    private ComboBox<String> directionComboBox;

    @FXML
    private TextField distanceTextField;

    @FXML
    private TextField occupiedArea;

    @Override
    public void initializeComponents() {

        referencePointComboBox.setEditable(true);
        referencePointComboBox.setPromptText(model.getReferencePoint());
        referencePointComboBox.valueProperty().addListener(new ReferencePointChangeAdapter(model));
        referencePointComboBox.setItems(model.getReferencePoints());
        
        directionComboBox.setEditable(true);
        directionComboBox.setPromptText(model.getDirection());
        directionComboBox.valueProperty().addListener(new DirectionChangeAdapter(model));
        directionComboBox.setItems(model.getDirections());
        
        distanceTextField.setText(model.getDistance());
        distanceTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        distanceTextField.textProperty().addListener(new DistanceChangeAdapter(model));
                 
        occupiedArea.setText(model.getOccupiedArea());
        occupiedArea.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        occupiedArea.textProperty().addListener(new OccupiedAreaChangeAdapter(model));       
    }
}
