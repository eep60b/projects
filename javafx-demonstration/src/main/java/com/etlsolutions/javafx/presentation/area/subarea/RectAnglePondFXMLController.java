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
public class RectAnglePondFXMLController extends AbstractComponentsFXMLController<RectAnglePondDataModel> {

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField depthTextField;    
    
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
 
        depthTextField.setText(model.getDepth());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new DepthChangeAdapter(model));        
    }
}
