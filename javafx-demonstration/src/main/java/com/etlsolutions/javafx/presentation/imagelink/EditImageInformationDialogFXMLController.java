package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.SaveEventHandler;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import static com.etlsolutions.javafx.presentation.imagelink.EditImageInformationDataModel.INFORMATION_PROPERTY;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class EditImageInformationDialogFXMLController extends AbstractComponentStageFXMLController<EditImageInformationDataModel> {

    private ImageLink imageLink;
    
    private Stage parentStage;
    
    @FXML
    private HBox imageHbox;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Label errorMesssageLabel;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button saveExitButton;
    
    @FXML
    private Button cancelButton;

    @Override
    public void initializeComponents() {
        imageHbox.getChildren().add(new ImageView(new Image(imageLink.getLink())));
        informationTextArea.setText(imageLink.getInformation());
        boolean valid = model.isInvalid();
        errorMesssageLabel.setText(model.getErrorMessage());
        errorMesssageLabel.setDisable(valid);
        saveButton.setDisable(!valid);
        saveExitButton.setDisable(!valid);
        
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        saveButton.setOnAction(new SaveEventHandler(model));
        saveExitButton.setOnAction(new SaveExitEventHandler(model, parentStage));
        cancelButton.setOnAction(new CancelEventHandler(parentStage));
        
        model.addPropertyChangeListener(INFORMATION_PROPERTY, new ImageLinkInformationPropertyChangeAdapter(errorMesssageLabel, saveButton, saveExitButton));
    }
}
