package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.area.AreaValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class IrregularPondFXMLController extends AbstractComponentsFXMLController<IrregularPondDataModel> {

    @FXML
    private TextField depthTextField;

    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {

        areaValueTextField.setText(model.getAreaValue());
        areaValueTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        areaValueTextField.textProperty().addListener(new AreaValueChangeAdapter(model));

        depthTextField.setText(model.getDepth());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new DepthChangeAdapter(model));
    }
}
