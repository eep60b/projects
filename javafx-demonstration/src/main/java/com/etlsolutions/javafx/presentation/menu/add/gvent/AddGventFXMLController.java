package com.etlsolutions.javafx.presentation.menu.add.gvent;

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
 * @author zc
 */
public class AddGventFXMLController extends DataUnitFXMLController<AddGventDataModel> {
    
    @FXML
    private TextField titleTextField;

    @FXML
    private HBox timeHbox;
    
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
        
        Label startTimeLabel = new Label("Start Time");
        DateTimePicker startTimePicker = new DateTimePicker();
        startTimePicker.setDateTimeValue(model.getStartTime());
        Label endTimeLabel = new Label("End Time");        
        DateTimePicker endTimePicker = new DateTimePicker();
        endTimePicker.setDateTimeValue(model.getEndTime());
        timeHbox.getChildren().clear();
        timeHbox.getChildren().addAll(startTimeLabel, startTimePicker, endTimeLabel,endTimePicker);
    }
    
}
