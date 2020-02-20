package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class FruitingGventFXMLController extends AbstractComponentsFXMLController<FruitingGventDetailDataModel> {

    @FXML
    private ComboBox<String> fruitShapeComboBox;

    @FXML
    private ComboBox<String> fruitColorComboBox;

    @FXML
    private CheckBox countableCheckBox;

    @FXML
    private HBox countHBox;

    @FXML
    private TextField averageSizeTextField;

    @FXML
    private TextField averageWeightTextField;

    @Override
    public void initializeComponents() {
        
        Spinner<Integer> countSpinner = new Spinner<>();
        SpinnerValueFactory.IntegerSpinnerValueFactory lengthBeforeFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100000);
        lengthBeforeFactory.setValue(model.getCount().getValue());
        countSpinner.setValueFactory(lengthBeforeFactory);
        countHBox.getChildren().add(countSpinner);
        
        fruitShapeComboBox.setItems(model.getFruitShapes());
        fruitShapeComboBox.setEditable(true);
        fruitShapeComboBox.getSelectionModel().select(model.getShape().getValue());
        fruitShapeComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getShape()));

        fruitColorComboBox.setItems(model.getFruitColors());
        fruitColorComboBox.setEditable(true);
        fruitColorComboBox.getSelectionModel().select(model.getColor().getValue());
        fruitColorComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getColor()));

        boolean countable = model.getCountable().getValue();
        countableCheckBox.selectedProperty().setValue(countable);
        countableCheckBox.selectedProperty().addListener(new ValueChangeAdapter<>(model.getCountable()));
        countHBox.setVisible(countable);

        averageSizeTextField.setText(String.valueOf(model.getAverageSize().getValue()));
        averageSizeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        averageSizeTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAverageSize()));        
        
        averageWeightTextField.setText(String.valueOf(model.getAverageWeight().getValue()));
        averageWeightTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        averageWeightTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAverageWeight())); 
        
        countSpinner.valueProperty().addListener(new ValueChangeAdapter<>(model.getCount()));
        
        model.getCountable().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValuePropertyChangeAdapter(countHBox));
    }
}
