package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AreaValueFXMLController extends AbstractComponentsFXMLController<AreaValueDataModel> {

    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {
        
        areaValueTextField.setText(model.getAreaValue());
        areaValueTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        areaValueTextField.textProperty().addListener(new AreaValueChangeAdapter(model));
    }
}
