package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import static com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel.IMAGE_FILE_LINK_PROPERTY;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddImageLinkDialogFXMLController implements Initializable {

    @FXML
    private Button addImageButton;
    
    @FXML
    private HBox imageHBox;
    
    @FXML
    private Label addImageButonLabel;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;
    private Stage stage;
    private DataUnitDataModel parentModel;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AddImageDataModel model = new AddImageDataModel();
        addImageButton.setOnAction(new AddImageEventHandler(model, stage));
        addImageButton.setText(model.hasImage() ? "Change Image" : "Add Image");
        informationTextArea.setText(model.getInformation());
        okButton.setDisable(!model.hasImage());   
        
        model.addPropertyChangeListener(IMAGE_FILE_LINK_PROPERTY, new ImagePropertyChangeAdapter(addImageButton, okButton, imageHBox));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        okButton.setOnAction(new ImageOkEventHandler(parentModel, model, stage));
        cancelButton.setOnAction(new ImageCancelEventHandler(stage));
    }    

    public void setOwnerWindow(Stage stage) {
        this.stage = stage;
    }

    void setParentModel(DataUnitDataModel parentModel) {
        this.parentModel = parentModel;
    }
}
