package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.area.LengthChangeAdapter;
import com.etlsolutions.javafx.presentation.area.WidthChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class BoxFXMLController extends AbstractComponentsFXMLController<BoxDataModel> {

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField heightTextField;    
    
    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getAreaValue());
        
        lengthTextField.setText(model.getLength());
        lengthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        lengthTextField.textProperty().addListener(new LengthChangeAdapter(model, areaValueTextField));

        widthTextField.setText(model.getWidth());
        widthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        widthTextField.textProperty().addListener(new WidthChangeAdapter(model, areaValueTextField));
 
        heightTextField.setText(model.getHeight());
        heightTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        heightTextField.textProperty().addListener(new HeightChangeAdapter(model));        
    }
}
