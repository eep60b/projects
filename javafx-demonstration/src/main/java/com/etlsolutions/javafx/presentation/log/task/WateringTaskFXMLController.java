package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.task.WaterType;
import com.etlsolutions.javafx.presentation.ValuedBooleanChangeAdapter;
import com.etlsolutions.javafx.data.log.task.WateringType;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class WateringTaskFXMLController extends AbstractComponentsFXMLController<WateringTaskDataModel> {

    @FXML
    RadioButton useWaterCanRadioButton;

    @FXML
    RadioButton useHoseCanRadioButton;

    @FXML
    private TextField useWaterCanTextField;

    @FXML
    private ComboBox<String> useWaterCanComboBox;

    @FXML
    RadioButton tapWaterRadioButton;

    @FXML
    RadioButton rainWaterRadioButton;

    @FXML
    TextField useHoseFluxTextField;

    @FXML
    private ComboBox<String> useHoseFluxComboBox;

    @FXML
    private CheckBox fertiliserCheckBox;

    @FXML
    private ComboBox<LiquidFertiliser> fertiliserComboBox;

    @FXML
    private Button addFertiliserButton;

    @FXML
    private Button editFertiliserButton;

    @FXML
    private Button removeFertiliserButton;

    @Override
    public void initializeComponents() {

        ToggleGroup wateringTypeToggleGroup = new ToggleGroup();
        useWaterCanRadioButton.setToggleGroup(wateringTypeToggleGroup);
        useHoseCanRadioButton.setToggleGroup(wateringTypeToggleGroup);

        switch (model.getWateringType().getValue()) {

            case USE_WATER_CAN:
                useWaterCanRadioButton.selectedProperty().setValue(Boolean.TRUE);
                break;
            case USE_HOSE:
                useHoseCanRadioButton.selectedProperty().setValue(Boolean.TRUE);
                break;
            default:
                throw new IllegalStateException("Invalid watering type.");

        }
        useWaterCanRadioButton.selectedProperty().addListener(new ValuedBooleanChangeAdapter<>(model.getWateringType(), WateringType.USE_WATER_CAN));
        useWaterCanRadioButton.selectedProperty().addListener(new ValuedBooleanChangeAdapter<>(model.getWateringType(), WateringType.USE_HOSE));

        useWaterCanTextField.setText(String.valueOf(model.getAmount().getValue()));
        useWaterCanTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        useWaterCanTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAmount()));

        useWaterCanComboBox.setItems(model.getWateringAmountUoms());
        useWaterCanComboBox.setEditable(true);
        useWaterCanComboBox.getSelectionModel().select(model.getAmountUom().getValue());
        useWaterCanComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getAmountUom()));

        useHoseFluxTextField.setText(String.valueOf(model.getFlux().getValue()));
        useHoseFluxTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        useHoseFluxTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getFlux()));

        useHoseFluxComboBox.setItems(model.getWateringFluxUoms());
        useHoseFluxComboBox.setEditable(true);
        useHoseFluxComboBox.getSelectionModel().select(model.getFluxUom().getValue());
        useHoseFluxComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getFluxUom()));

        ToggleGroup waterTypeToggleGroup = new ToggleGroup();
        tapWaterRadioButton.setToggleGroup(waterTypeToggleGroup);
        rainWaterRadioButton.setToggleGroup(waterTypeToggleGroup);

        switch (model.getWaterType().getValue()) {

            case TAP_WATER:
                tapWaterRadioButton.selectedProperty().setValue(Boolean.TRUE);
                break;
            case RAIN_WATER:
                rainWaterRadioButton.selectedProperty().setValue(Boolean.TRUE);
                break;
            default:
                throw new IllegalStateException("Invalid watering type.");

        }
        
        tapWaterRadioButton.selectedProperty().addListener(new ValuedBooleanChangeAdapter<>(model.getWaterType(), WaterType.TAP_WATER));
        rainWaterRadioButton.selectedProperty().addListener(new ValuedBooleanChangeAdapter<>(model.getWaterType(), WaterType.RAIN_WATER));

        fertiliserCheckBox.selectedProperty().setValue(model.getFertilised().getValue());
        fertiliserCheckBox.selectedProperty().addListener(new ValueChangeAdapter<>(model.getFertilised()));
        
        fertiliserComboBox.setItems(model.getFertilisers());
        fertiliserComboBox.getSelectionModel().select(model.getFertiliser().getValue());
        fertiliserComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getFertiliser()));

    }
}
