package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.SaveEventHandler;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class EditImageInformationDialogFXMLController extends AbstractComponentStageFXMLController<EditImageInformationDataModel> {

    @FXML
    private HBox imageHbox;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button saveExitButton;
    
    @FXML
    private Button cancelButton;

    @Override
    public void initializeComponents() {
        imageHbox.getChildren().add(new ImageView(new Image(model.getImageLink())));
        informationTextArea.setText(model.getInformationValueWrapper().getValue());        
        informationTextArea.textProperty().addListener(new ValueChangeAdapter<>(model.getInformationValueWrapper()));
        
        saveButton.setOnAction(new SaveEventHandler(model));
        saveExitButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));
    }
}
