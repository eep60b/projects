package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import static com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel.*;
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
public class AddImageLinkDialogFXMLController extends AbstractComponentsFXMLController<AddImageDataModel>{

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
        informationTextArea.setText(model.getInformation());
        errorMessageLabel.setText(model.getErrorMessage());
        boolean valid = model.isValid();
        okButton.setDisable(valid);
        errorMessageLabel.setVisible(!valid);
        errorMessageLabel.setText(model.getErrorMessage());
       
        model.addPropertyChangeListener(IMAGE_FILE_LINK_PROPERTY, new ImagePropertyChangeAdapter(imageHbox, errorMessageLabel, okButton));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));
    }
}
