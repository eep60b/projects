package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AreaFXMLController extends DataUnitFXMLController<AbstractAreaDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<AreaType> typeComboBox;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<AreaShape> shapeComboBox;

    @FXML
    private TextField longitudeTextField;

    @FXML
    private TextField latitudeTextField;

    @FXML
    private Tab measurementTab;   

     
    @FXML
    private Tab contentsTab;
    
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

    /**
     * Initialises the components in this dialog.
     *
     */
    @Override
    public void initializeComponents() {

        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        typeComboBox.setItems(model.getAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedAreaType());
        typeComboBox.setDisable(model.getAreaTypes().size() <= 1);
        shapeComboBox.setItems(model.getAreaShapes());
        shapeComboBox.getSelectionModel().select(model.getSelectedAreaShape());
        longitudeTextField.setText(String.valueOf(model.getLongitude()));
        longitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        latitudeTextField.setText(String.valueOf(model.getLatitude()));
        latitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new AreaTypeChangeAdapter(model, shapeComboBox));
        shapeComboBox.getSelectionModel().selectedItemProperty().addListener(new AreaShapeChangeAdapter(model, new AreaMeasurementDataModel(model.getMeasurement()), measurementTab));
        longitudeTextField.textProperty().addListener(new LongitudeChangeAdapter(model));
        latitudeTextField.textProperty().addListener(new LatitudeChangeAdapter(model));
        
    }
}
