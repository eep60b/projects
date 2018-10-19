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
public class CircleFXMLController extends AbstractComponentsFXMLController<CircleDataModel> {

    @FXML
    private TextField diameterTextField;

    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getAreaValue());

        diameterTextField.setText(model.getDiameter());
        diameterTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        diameterTextField.textProperty().addListener(new DiameterChangeAdapter(model, areaValueTextField));
    }

}
