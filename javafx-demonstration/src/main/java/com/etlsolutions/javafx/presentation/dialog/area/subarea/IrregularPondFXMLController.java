package com.etlsolutions.javafx.presentation.dialog.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
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

        areaValueTextField.setText(model.getAreaValueWrapper().getValue());
        areaValueTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        areaValueTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAreaValueWrapper()));

        depthTextField.setText(model.getHeightValueWrapper().getValue());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getHeightValueWrapper()));
    }
}
