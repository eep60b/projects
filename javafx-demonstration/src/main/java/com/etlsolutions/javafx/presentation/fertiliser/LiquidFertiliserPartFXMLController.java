package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.presentation.BooleanValueNodeChangeAdapter;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class LiquidFertiliserPartFXMLController extends AbstractComponentsFXMLController<LiquidFertiliserPartDataModel> {

    @FXML
    private CheckBox delutedCheckBox;

    @FXML
    private TextField dilutionRationTextField;
    
    @FXML
    private ComboBox<String> dilutionRatioUomComboBox;


    @Override
    public void initializeComponents() {
                
        delutedCheckBox.setSelected(model.getDiluted().getValue());
        delutedCheckBox.selectedProperty().addListener(new ValueChangeAdapter<>(model.getDiluted()));
        delutedCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getDilutionRatio(), dilutionRationTextField, dilutionRatioUomComboBox));
        
        dilutionRationTextField.setText(String.valueOf(model.getDilutionRatio().getValue()));
        dilutionRationTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        dilutionRationTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getDilutionRatio()));           
        
        dilutionRatioUomComboBox.setItems(model.getDilutionRationUoms());
        dilutionRatioUomComboBox.setEditable(true);
        dilutionRatioUomComboBox.getSelectionModel().select(model.getDilutionRatioUom().getValue());
        dilutionRatioUomComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getDilutionRatioUom()));
    }
}
