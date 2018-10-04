package com.etlsolutions.javafx.presentation.menu.add.area;

import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AddAreaDialogFXMLController extends DataUnitFXMLController<AddAreaDialogDataModel> {

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
    private Button moveToBeginButton;
    
    @FXML
    private Button moveToLeftButton;
    
    @FXML
    private Button moveToRightButton;
    
    @FXML
    private Button moveToEndButton;

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
     * Initialises the components in this dialog.
     *
     */
    @Override
    public void initializeComponents() {
        
        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginButton, moveToLeftButton, moveToRightButton, moveToEndButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        typeComboBox.setItems(model.getAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedAreaType());

        typeComboBox.selectionModelProperty().addListener(new AreaTypeChangeAdapter(model));
    }
}
