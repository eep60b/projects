package com.etlsolutions.javafx.presentation.menu.add.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.FxmlControllable;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import com.etlsolutions.javafx.presentation.imagelink.AddImageLinkEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.RemoveImageLinkEventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AddAreaDialogFXMLController implements FxmlControllable<AddAreaDialogDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox typeComboBox;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private Button addImageButton;

    @FXML
    private Button editImageButton;

    @FXML
    private Button removeImageButton;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Tab contentsTab;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AddAreaDialogDataModel model = new AddAreaDialogDataModel();

        titleTextField.setText(model.getTitle());
        typeComboBox.setItems(model.getAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedAreaType());
        informationTextArea.setText(model.getInformation());

        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        typeComboBox.selectionModelProperty().addListener(new AreaTypeChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        addImageButton.setOnAction(new AddImageLinkEventHandler(model));
        editImageButton.setOnAction(new EditImageInformationEventHandler(model.getSelectedImageLink()));
        removeImageButton.setOnAction(new RemoveImageLinkEventHandler(model));
        for (ImageLink link : model.getImageLinks()) {
            imageTilePane.getChildren().addAll(new ImageView(new Image(link.getLink())));
        }
    }

    @Override
    public void setModel(AddAreaDialogDataModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStage(Stage starge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
