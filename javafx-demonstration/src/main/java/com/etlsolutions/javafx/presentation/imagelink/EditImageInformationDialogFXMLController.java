package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class EditImageInformationDialogFXMLController implements Initializable {

    private ImageLink imageLink;

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
        
        informationArea.textProperty().addListener(new InformationChangeAdapter(model));
        
    }    

    public void setImageLink(ImageLink imageLink) {
        this.imageLink = imageLink;
    }
    
}
