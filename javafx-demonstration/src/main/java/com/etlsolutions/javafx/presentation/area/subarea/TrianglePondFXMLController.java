package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.area.AreaMeasurablePropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class TrianglePondFXMLController extends AbstractComponentsFXMLController<TrianglePondDataModel> {

    @FXML
    private TextField areaValueTextField;

    @FXML
    private TextField aTextField;

    @FXML
    private TextField bTextField;

    @FXML
    private TextField cTextField;
    
    
    @FXML
    private TextField depthTextField;    

    @Override
    public void initializeComponents() {
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getArea());

        aTextField.setText(model.getAValueWrapper().getValue());
        aTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        aTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAValueWrapper()));

        bTextField.setText(model.getBValueWrapper().getValue());
        bTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        bTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getBValueWrapper()));

        cTextField.setText(model.getCValueWrapper().getValue());
        cTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        cTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getCValueWrapper()));

        
        depthTextField.setText(model.getHeightValueWrapper().getValue());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getHeightValueWrapper()));           
        
        AreaMeasurablePropertyChangeAdapter adapter = new AreaMeasurablePropertyChangeAdapter(model.getMeasurementValueWrapper(), areaValueTextField);
        model.getAValueWrapper().addPropertyChangeListener(adapter);
        model.getBValueWrapper().addPropertyChangeListener(adapter);
        model.getCValueWrapper().addPropertyChangeListener(adapter);
     
    }
}
