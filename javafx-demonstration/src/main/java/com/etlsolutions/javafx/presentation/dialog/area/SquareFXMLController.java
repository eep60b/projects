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
public class SquareFXMLController extends AbstractComponentsFXMLController<SquareDataModel> {

    @FXML
    private TextField sideTextField;

    @FXML
    private TextField areaValueTextField;

    @Override
    public void initializeComponents() {
        areaValueTextField.setDisable(true);
        areaValueTextField.setText(model.getAreaString());

        sideTextField.setText(model.getSideValueWrapper().getValue());
        sideTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        sideTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getSideValueWrapper()));

        AreaMeasurablePropertyChangeAdapter adapter = new AreaMeasurablePropertyChangeAdapter(model.getMeasurementValueWrapper(), areaValueTextField);
        model.getSideValueWrapper().addPropertyChangeListener(adapter);
    }
}
