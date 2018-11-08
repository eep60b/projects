package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import com.etlsolutions.javafx.data.log.GrowingIssue;
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
public class AddGrowingIssueFXMLController extends DataUnitFXMLController<GrowingIssue, AddGrowingIssueDataModel>{

    @FXML
    private TextField titleTextField;

    @FXML
    private HBox timeHbox;
    
    @FXML
    private TextArea informationTextArea;

    @FXML
    private TextArea solutionTextArea;

    @FXML
    private TextArea effectivenessTextArea;

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
        
        solutionTextArea.setText(model.getSolution());
        effectivenessTextArea.setText(model.getEffectiveness());
        
        solutionTextArea.textProperty().addListener(new SolutionChangeAdapter(model));
        effectivenessTextArea.textProperty().addListener(new EffectivenessChangeAdapter(model));
    }
}
