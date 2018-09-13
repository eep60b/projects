package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.SaveEventHandler;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import static com.etlsolutions.javafx.presentation.imagelink.EditImageInformationDataModel.INFORMATION_PROPERTY;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class EditImageInformationDialogFXMLController implements Initializable {

    private ImageLink imageLink;
    
    private Stage parentStage;
    
    @FXML
    private HBox imageHBox;
    
    @FXML
    private TextArea informationArea;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button saveExitButton;
    
    @FXML
    private Button cancelButton;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EditImageInformationDataModel model = new EditImageInformationDataModel(imageLink);
        
        imageHBox.getChildren().add(new ImageView(new Image(imageLink.getLink())));
        informationArea.setText(imageLink.getInformation());
        saveButton.setDisable(model.isNotChanged());
        saveExitButton.setDisable(model.isNotChanged());
        
        informationArea.textProperty().addListener(new InformationChangeAdapter(model));
        saveButton.setOnAction(new SaveEventHandler(model));
        saveExitButton.setOnAction(new SaveExitEventHandler(model, parentStage));
        cancelButton.setOnAction(new CancelEventHandler(parentStage));
        
        model.addPropertyChangeListener(INFORMATION_PROPERTY, new ImageLinkInformationPropertyChangeAdapter(saveButton, saveExitButton));
    }    

    public void setImageLink(ImageLink imageLink) {
        this.imageLink = imageLink;
    }

    public void setStage(Stage parentStage) {
        this.parentStage = parentStage;
    }
}
