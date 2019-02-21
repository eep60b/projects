package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddImageLinkDialogFXMLController extends AbstractComponentStageFXMLController<AddImageToFXMLDataModel>{

    @FXML
    private Button selectImageButton;

    @FXML
    private HBox imageHbox;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @Override
    public void initializeComponents() {
  
        selectImageButton.setOnAction(new SelectImageFileEventHandler(model, stage));
        informationTextArea.setText(model.getInformationValueWrapper().getValue());
        
        ImagePropertyChangeAdapter imagePropertyChangeAdapter = new ImagePropertyChangeAdapter(imageHbox, errorMessageLabel, okButton);
        imagePropertyChangeAdapter.process(model.getImageFileLinkValueWrapper());
       
        model.getImageFileLinkValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, imagePropertyChangeAdapter);
        informationTextArea.textProperty().addListener(new ValueChangeAdapter<>(model.getInformationValueWrapper()));
        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));
    }
}
