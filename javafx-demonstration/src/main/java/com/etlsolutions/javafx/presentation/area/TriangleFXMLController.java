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
public class TriangleFXMLController extends AbstractComponentsFXMLController<TriangleDataModel> {

    @FXML
    private TextField areaValueTextField;

    @FXML
    private TextField aTextField;

    @FXML
    private TextField bTextField;

    @FXML
    private TextField cTextField;

    @Override
    public void initializeComponents() {
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getAreaValue());

        aTextField.setText(model.getA());
        aTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        aTextField.textProperty().addListener(new TriangleaChangeAdapter(model, areaValueTextField));
        
        bTextField.setText(model.getB());
        bTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        bTextField.textProperty().addListener(new TrianglebChangeAdapter(model, areaValueTextField));
        
        cTextField.setText(model.getC());
        cTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        cTextField.textProperty().addListener(new TrianglecChangeAdapter(model, areaValueTextField));
    }

}
