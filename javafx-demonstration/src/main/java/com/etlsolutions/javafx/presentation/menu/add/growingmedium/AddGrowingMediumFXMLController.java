package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
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
public class AddGrowingMediumFXMLController extends DataUnitFXMLController<AddGrowingMediumDataModel> {

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
    private TextField organicMaterialPercentageTextField;

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

        sandPercentageTextField.setText(String.valueOf(model.getSandPercentage()));
        sandPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        siltPercentageTextField.setText(String.valueOf(model.getSiltPercentage()));
        siltPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        clayPercentageTextField.setText(String.valueOf(model.getClayPercentage()));
        clayPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        stonePercentageTextField.setText(String.valueOf(model.getStonePercentage()));
        stonePercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        organicMaterialPercentageTextField.setText(String.valueOf(model.getOrganicPercentage()));
        organicMaterialPercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        waterStoragePercentageTextField.setText(String.valueOf(model.getWaterStoragePercentage()));
        waterStoragePercentageTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        phTextField.setText(String.valueOf(model.getPh()));
        phTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        sandPercentageTextField.textProperty().addListener(new SandPercentageChangeAdapter(model));
        siltPercentageTextField.textProperty().addListener(new SiltPercentageChangeAdapter(model));
        clayPercentageTextField.textProperty().addListener(new ClayPercentageChangeAdapter(model));
        stonePercentageTextField.textProperty().addListener(new StonePercentageChangeAdapter(model));
        organicMaterialPercentageTextField.textProperty().addListener(new OrganicMaterialPercentageChangeAdapter(model));
        waterStoragePercentageTextField.textProperty().addListener(new WaterStoragePercentageChangeAdapter(model));
        phTextField.textProperty().addListener(new PhChangeAdapter(model));
    }
}
