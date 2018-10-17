package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.presentation.plant.SelectPlantGroupChangeAdapter;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel;
import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationDataModel;
import com.etlsolutions.javafx.presentation.imagelink.ImageLinksAdapter;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToBeginEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToEndEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToLeftEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToRightEventHandler;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.SelectedImageLinkAdapter;
import static com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddPlantTypeDialogFXMLController implements Initializable {

    @FXML
    private TextField titleTextField;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private ComboBox<PlantGroup> groupComboBox;
    
    @FXML
    private Button addVarityButton;
    
    @FXML
    private Button removeVarityButton;
    
    @FXML
    private Button editVarityButton;
    
    @FXML 
    private ListView varityListView;
    
    @FXML
    private Button addImageButton;
    
    @FXML
    private Button removeImageButton;
    
    @FXML
    private Button editImageButton;
    
    @FXML
    private Button moveToBeginButton;
    
    @FXML
    private Button moveToLeftButton;
    
    @FXML
    private Button moveToRightButton;
    
    @FXML
    private Button moveToEndButton;
    
    @FXML
    private HBox imagesHbox;
    
    @FXML
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;
    
    
    private Stage stage;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AddPlantTypeDialogDataModel model = new AddPlantTypeDialogDataModel();
        titleTextField.setText(model.getTitle());
        informationTextArea.setText(model.getInformation());
        
        groupComboBox.getItems().addAll(model.getPlantGroups());
        groupComboBox.getSelectionModel().select(model.getSelectedPlantGroup());
        
        removeVarityButton.setDisable(model.getSelectedVariety() == null);
        editVarityButton.setDisable(model.getSelectedVariety() == null);
        varityListView.setItems(model.getVarieties());
        varityListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        varityListView.getSelectionModel().select(model.getSelectedVariety());
        
           
        ImageLink selectedImageLink = model.getSelectedImageLink();
        removeImageButton.setDisable(selectedImageLink == null);
        List<ImageLink> imageLinks = model.getImageLinks();
        moveToBeginButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToLeftButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToEndButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        moveToRightButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        editImageButton.setDisable(selectedImageLink == null);     
        
        errorMessageLabel.setVisible(!model.isValid());
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isValid());
        
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        groupComboBox.selectionModelProperty().addListener(new SelectPlantGroupChangeAdapter(model));        
        addVarityButton.setOnAction(new FXMLActionEventHandler<>(model));
        removeVarityButton.setOnAction(new RemovePlantVarietyEventHandler(model));
        editVarityButton.setOnAction(new FXMLActionEventHandler<>(model));
        varityListView.getSelectionModel().selectionModeProperty().addListener(new PlantVarietySelectionChangeAdapter(model));
        
        addImageButton.setOnAction(new FXMLActionEventHandler<>(new AddImageDataModel(model)));
        removeImageButton.setOnAction(new RemoveEventHandler(model, SELECTED_IMAGE_LINK_REMOVE_EVENT_ID));
        moveToBeginButton.setOnAction(new MoveImageLinkToBeginEventHandler(model));
        moveToLeftButton.setOnAction(new MoveImageLinkToLeftEventHandler(model));
        moveToEndButton.setOnAction(new MoveImageLinkToEndEventHandler(model));
        moveToRightButton.setOnAction(new MoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new FXMLActionEventHandler<>(new EditImageInformationDataModel(model.getSelectedImageLink())));        

        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));
        
        model.addPropertyChangeListener(TITLE_PROPERTY, new ValidationPropertyChangeAdapter(errorMessageLabel, okButton));
        model.addPropertyChangeListener(SELECTED_VARIETY_PROPERTY, new PlantVarietySelectionProertyChangeAdapter(editVarityButton, removeVarityButton, varityListView));
        model.addPropertyChangeListener(SELECTED_IMAGE_LINK_PROPERTY, new SelectedImageLinkAdapter(removeImageButton, moveToBeginButton, moveToLeftButton, moveToEndButton, moveToRightButton, editImageButton, imagesHbox));
        model.getImageLinks().addListener(new ImageLinksAdapter(model, imagesHbox));        
    }    
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }    
}
