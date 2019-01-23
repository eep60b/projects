package com.etlsolutions.javafx.presentation.dialog.area;

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
public class LengthWidthFXMLController extends AbstractComponentsFXMLController<RectangleDataModel> {

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField widthTextField;

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

        AreaMeasurablePropertyChangeAdapter adapter = new AreaMeasurablePropertyChangeAdapter(model.getMeasurementValueWrapper(), areaValueTextField);
        model.getLengthValueWrapper().addPropertyChangeListener(adapter);
        model.getWidthValueWrapper().addPropertyChangeListener(adapter);
    }
}
