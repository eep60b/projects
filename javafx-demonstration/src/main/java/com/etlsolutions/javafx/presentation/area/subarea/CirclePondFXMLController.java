package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.area.DiameterChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class CirclePondFXMLController extends AbstractComponentsFXMLController<CirclePondDataModel> {

    @FXML
    private TextField diameterTextField;
    
    @FXML
    private TextField depthTextField;
    
    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getAreaValue());

        diameterTextField.setText(model.getDiameter());
        diameterTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        diameterTextField.textProperty().addListener(new DiameterChangeAdapter(model, areaValueTextField));

        depthTextField.setText(model.getDepth());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new DepthChangeAdapter(model));
    }
}