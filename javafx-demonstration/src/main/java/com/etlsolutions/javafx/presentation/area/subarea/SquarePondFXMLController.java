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
        areaValueTextField.setText(model.getAreaString());

        sideTextField.setText(model.getSideValueWrapper().getValue());
        sideTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        sideTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getSideValueWrapper()));

        depthTextField.setText(model.getHeightValueWrapper().getValue());
        depthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        depthTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getHeightValueWrapper()));

        AreaMeasurablePropertyChangeAdapter adapter = new AreaMeasurablePropertyChangeAdapter(model.getMeasurementValueWrapper(), areaValueTextField);
        model.getSideValueWrapper().addPropertyChangeListener(adapter);

    }
}
