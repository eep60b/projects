/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.area.subarea.ContainerSetDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.HeightChangeAdapter;
import com.etlsolutions.javafx.presentation.area.subarea.NumberChangeAdapter;
import com.etlsolutions.javafx.presentation.area.subarea.VolumeChangeAdapter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

        shapecComboBox.setPromptText(model.getShape());
        shapecComboBox.setEditable(true);
        shapecComboBox.valueProperty().addListener(new ShapeChangeAdapter(model));

        volumeTextField.setText(model.getVolume());
        volumeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        volumeTextField.textProperty().addListener(new VolumeChangeAdapter(model));

        heightTextField.setText(model.getHeight());
        heightTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        heightTextField.textProperty().addListener(new HeightChangeAdapter(model));
    }
}
