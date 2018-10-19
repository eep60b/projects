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
public class SquareFXMLController extends AbstractComponentsFXMLController<SquareDataModel>{
    
    @FXML
    private TextField sideTextField;
    
    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getAreaValue());
        
        sideTextField.setText(model.getSide());
        sideTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        sideTextField.textProperty().addListener(new SideChangeAdapter(model, areaValueTextField));
    }    
}
