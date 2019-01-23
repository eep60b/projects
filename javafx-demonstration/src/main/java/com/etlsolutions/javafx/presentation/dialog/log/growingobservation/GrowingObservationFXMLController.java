package com.etlsolutions.javafx.presentation.dialog.log.growingobservation;

import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class GrowingObservationFXMLController extends DataUnitFXMLController<GrowingObservation, AbstractGrowingObservationDataModel>{

    @FXML
    private TextField titleTextField;

    @FXML
    private HBox startTimeHbox;

    @FXML
    private HBox endTimeHbox;
    
    @FXML
    private TextArea informationTextArea;

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

        DateTimePicker startTimePicker = new DateTimePicker();
        startTimePicker.setDateTimeValue(model.getStartTimeValueWrapper().getValue());
        startTimeHbox.getChildren().addAll(startTimePicker);
        
        DateTimePicker endTimePicker = new DateTimePicker();
        endTimePicker.setDateTimeValue(model.getEndTimeValueWrapper().getValue());
        endTimeHbox.getChildren().addAll(endTimePicker);
    }
}
