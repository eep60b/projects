package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class SolidFertiliserFXMLController extends AbstractComponentsFXMLController<SolidFertiliserDataModel> {

    @FXML
    private TextField densityTextField;
    
    @FXML
    private ComboBox<String> densityUomComboBox;


    @Override
    public void initializeComponents() {
                

        densityTextField.setText(String.valueOf(model.getDensity().getValue()));
        densityTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        densityTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getDensity()));           
        
        densityUomComboBox.setItems(model.getDensityUoms());
        densityUomComboBox.setEditable(true);
        densityUomComboBox.getSelectionModel().select(model.getDensityUom().getValue());
        densityUomComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getDensityUom()));
    }
}
