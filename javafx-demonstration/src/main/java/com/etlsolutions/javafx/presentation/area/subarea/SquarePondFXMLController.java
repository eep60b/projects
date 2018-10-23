package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.area.SideChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class SquarePondFXMLController extends AbstractComponentsFXMLController<SquarePondDataModel> {

    @FXML
    private TextField sideTextField;
    
    @FXML
    private TextField depthTextField;
    
    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {
        
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getAreaValue());

        sideTextField.setText(model.getSide());
        sideTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        sideTextField.textProperty().addListener(new SideChangeAdapter(model, areaValueTextField));

        depthTextField.setText(model.getDepth());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new DepthChangeAdapter(model));
    }
}