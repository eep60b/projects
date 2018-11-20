package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
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
        areaValueTextField.setText(model.getAreaString());

        diameterTextField.setText(model.getDiameterValueWrapper().getValue());
        diameterTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        diameterTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getDiameterValueWrapper()));
        
        AreaMeasurablePropertyChangeAdapter adapter = new AreaMeasurablePropertyChangeAdapter(model.getMeasurementValueWrapper(), areaValueTextField);
        model.getDiameterValueWrapper().addPropertyChangeListener(adapter);        
    }
}