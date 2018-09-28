package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.ImageLinksAdapter;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToBeginEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToLeftEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToEndEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToRightEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.RemoveImageLinkEventHandler;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.imagelink.AddImageLinkEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.SelectedImageLinkAdapter;
import static com.etlsolutions.javafx.presentation.menu.add.plantvariety.VarietyDialogDataModel.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import com.etlsolutions.javafx.presentation.FxmlControllable;

/**
 * AddPlantVarietyDialogFXMLController is an FXML Controller class which control the add plant variety dialog.
 *
 * @author zc
 */
public class AddPlantVarietyDialogFXMLController implements FxmlControllable<VarietyAddable> {

    
    private VarietyAddable parentModel;
    
    private Stage parentStage;    
    
    @FXML
    private TextField titleTextField;

    @FXML
    private TextField latinNameTextField;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button addAliasButton;
    
    @FXML
    private Button removeAliasButton;
    
    @FXML
    private Button editAliasButton;
    
    @FXML 
    private ListView aliasListView;
    
    @FXML
    private Button addImageButton;
    
    @FXML
    private Button removeImageButton;
    
    @FXML
    private Button moveToBeginButton;
    
    @FXML
    private Button moveToLeftButton;
    
    @FXML
    private Button moveToRightButton;
    
    @FXML
    private Button moveToEndButton;
    
    @FXML
    private Button editImageButton;
    
    @FXML
    private HBox imagesHbox;
    
    @FXML
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;   

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        VarietyDialogDataModel model = new VarietyDialogDataModel(parentModel);
        titleTextField.setText(model.getTitle());
        latinNameTextField.setText(model.getLatinName());
        informationTextArea.setText(model.getInformation());
        String alias = model.getSelectedAlias();
        removeAliasButton.setDisable(alias == null);
        editAliasButton.setDisable(alias == null);
        
        aliasListView.setItems( model.getAliases());
        MultipleSelectionModel selectionModel = aliasListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        if(alias != null) {
            selectionModel.select(alias);
        }
        
        ImageLink selectedImageLink = model.getSelectedImageLink();
        removeImageButton.setDisable(selectedImageLink == null);
        List<ImageLink> imageLinks = model.getImageLinks();
        moveToBeginButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToLeftButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToEndButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        moveToRightButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        editImageButton.setDisable(selectedImageLink == null);
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isValid());
                
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        latinNameTextField.textProperty().addListener(new LatinNameChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        addAliasButton.setOnAction(new AddAliasEventHandler(model));
        removeAliasButton.setOnAction(new RemoveAliasEventHandler(model));
        
        aliasListView.selectionModelProperty().addListener(new AliasChangeAdapter(model));
        addImageButton.setOnAction(new AddImageLinkEventHandler(model));
        removeImageButton.setOnAction(new RemoveImageLinkEventHandler(model));
        moveToBeginButton.setOnAction(new MoveImageLinkToBeginEventHandler(model));
        moveToLeftButton.setOnAction(new MoveImageLinkToLeftEventHandler(model));
        moveToEndButton.setOnAction(new MoveImageLinkToEndEventHandler(model));
        moveToRightButton.setOnAction(new MoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new EditImageInformationEventHandler(model.getSelectedImageLink()));
        okButton.setOnAction(new SaveExitEventHandler(model, parentStage));
        cancelButton.setOnAction(new CancelEventHandler(parentStage));
        
        model.addPropertyChangeListener(SELECTED_ALIAS_PROPERTY, new SelectedAliasChangeAdapter(removeAliasButton, aliasListView));
        model.addPropertyChangeListener(SELECTED_IMAGE_LINK_PROPERTY, new SelectedImageLinkAdapter(removeImageButton, moveToBeginButton, moveToLeftButton, moveToEndButton, moveToRightButton, editImageButton, imagesHbox));
        model.addPropertyChangeListener(IMAGE_LINKS_PROPERTY, new ImageLinksAdapter(imagesHbox));
        model.addPropertyChangeListener(TITLE_PROPERTY, new ValidationPropertyChangeAdapter(errorMessageLabel, okButton));
    }    

    @Override
    public void setModel(VarietyAddable parentModel) {
        this.parentModel = parentModel;
    }

    @Override
    public void setStage(Stage parentStage) {
        this.parentStage = parentStage;
    }
}
