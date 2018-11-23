package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
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
        referencePointComboBox.setPromptText(model.getReferencePointValueWrapper().getValue());
        referencePointComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getReferencePointValueWrapper()));
        referencePointComboBox.setItems(model.getReferencePoints());
        
        directionComboBox.setEditable(true);
        directionComboBox.setPromptText(model.getDirectionValueWrapper().getValue());
        directionComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getDirectionValueWrapper()));
        directionComboBox.setItems(model.getDirections());
        
        distanceTextField.setText(model.getDistanceValueWrapper().getValue());
        distanceTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        distanceTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getDistanceValueWrapper()));
                 
        occupiedArea.setText(model.getOccupiedAreaValueWrapper().getValue());
        occupiedArea.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        occupiedArea.textProperty().addListener(new ValueChangeAdapter<>(model.getOccupiedAreaValueWrapper()));       
    }
}
