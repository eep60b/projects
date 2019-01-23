package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class ContainerFXMLController extends AbstractComponentsFXMLController<ContainerDataModel> {

    @FXML
    private ComboBox<String> shapecComboBox;

    @FXML
    private TextField volumeTextField;

    @FXML
    private TextField heightTextField;

    @Override
    public void initializeComponents() {

        shapecComboBox.setPromptText(model.getShapeValueWrapper().getValue());
        shapecComboBox.setEditable(true);
        shapecComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getShapeValueWrapper()));

        volumeTextField.setText(model.getVolumeValueWrapper().getValue());
        volumeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        volumeTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getVolumeValueWrapper()));

        heightTextField.setText(model.getHeightValueWrapper().getValue());
        heightTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        heightTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getHeightValueWrapper()));
    }
}
