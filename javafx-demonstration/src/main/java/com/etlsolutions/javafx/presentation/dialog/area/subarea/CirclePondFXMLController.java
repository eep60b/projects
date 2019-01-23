package com.etlsolutions.javafx.presentation.dialog.area.subarea;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.dialog.area.AreaMeasurablePropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
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
        areaValueTextField.setText(model.getAreaString());

        diameterTextField.setText(model.getDiameterValueWrapper().getValue());
        diameterTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        diameterTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getDiameterValueWrapper()));

        depthTextField.setText(model.getHeightValueWrapper().getValue());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getHeightValueWrapper()));

        AreaMeasurablePropertyChangeAdapter adapter = new AreaMeasurablePropertyChangeAdapter(model.getMeasurementValueWrapper(), areaValueTextField);
        model.getDiameterValueWrapper().addPropertyChangeListener(adapter);
    }
}
