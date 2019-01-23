package com.etlsolutions.javafx.presentation.dialog.growingmedium;

import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddGrowingMediumFXMLController extends DataUnitFXMLController<GrowingMedium, AddGrowingMediumDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private TextField sandPercentageTextField;

    @FXML
    private TextField siltPercentageTextField;

    @FXML
    private TextField clayPercentageTextField;

    @FXML
    private TextField stonePercentageTextField;

    @FXML
    private TextField organicPercentageTextField;

    @FXML
    private TextField waterStoragePercentageTextField;

    @FXML
    private TextField phTextField;

    @FXML
    private Button addImageButton;

    @FXML
    private Button editImageButton;

    @FXML
    private Button removeImageButton;

    @FXML
    private Button moveToBeginImageButton;

    @FXML
    private Button moveToLeftImageButton;

    @FXML
    private Button moveToRightImageButton;

    @FXML
    private Button moveToEndImageButton;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @Override
    public void initializeComponents() {
        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        sandPercentageTextField.setText(model.getSandPercentage().getValue());
        sandPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        siltPercentageTextField.setText(model.getSiltPercentage().getValue());
        siltPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        clayPercentageTextField.setText((model.getClayPercentage().getValue()));
        clayPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        stonePercentageTextField.setText(model.getStonePercentage().getValue());
        stonePercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        organicPercentageTextField.setText(model.getOrganicPercentage().getValue());
        organicPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        waterStoragePercentageTextField.setText(model.getWaterStoragePercentage().getValue());
        waterStoragePercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        phTextField.setText(model.getPh().getValue());
        phTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        sandPercentageTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getSandPercentage()));
        siltPercentageTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getSiltPercentage()));
        clayPercentageTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getClayPercentage()));
        stonePercentageTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getStonePercentage()));
        organicPercentageTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getOrganicPercentage()));
        waterStoragePercentageTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getWaterStoragePercentage()));
        phTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getPh()));
    }
}
