package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.area.AreaMeasurablePropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
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
        areaValueTextField.setText(model.getAreaString());
        
        lengthTextField.setText(model.getLengthValueWrapper().getValue());
        lengthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        lengthTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getLengthValueWrapper()));

        widthTextField.setText(model.getWidthValueWrapper().getValue());
        widthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        widthTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getWidthValueWrapper()));
 
        heightTextField.setText(model.getHeightValueWrapper().getValue());
        heightTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        heightTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getHeightValueWrapper()));
        
        AreaMeasurablePropertyChangeAdapter adapter = new AreaMeasurablePropertyChangeAdapter(model.getMeasurementValueWrapper(), areaValueTextField);
        model.getLengthValueWrapper().addPropertyChangeListener(adapter);
        model.getWidthValueWrapper().addPropertyChangeListener(adapter);  
    }
}
