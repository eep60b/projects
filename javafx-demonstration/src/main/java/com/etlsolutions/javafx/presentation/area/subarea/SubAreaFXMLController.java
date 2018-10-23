package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import static com.etlsolutions.javafx.presentation.area.subarea.AbstractAreaDefinedSubAreaDataModel.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class SubAreaFXMLController extends DataUnitFXMLController<AbstractAreaDefinedSubAreaDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<SubAreaType> typeComboBox;

    @FXML
    private ComboBox<SubAreaShape> shapeComboBox;

    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Tab measurementTab;    
   
    @FXML
    private Button addImageButton;

    @FXML
    private Button editImageButton;

    @FXML
    private Button removeImageButton;

    @FXML
    private Button moveToBeginImageButton;

    @FXML
    private Button moveToLeftImageButton;

    @FXML
    private Button moveToRightImageButton;

    @FXML
    private Button moveToEndImageButton;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private final Map<SubAreaShape, Node> map = new HashMap<>();    
    /**
     * Initialises the components in this dialog.
     *
     */
    @Override
    public void initializeComponents() {

        for (SubAreaShape shape : SubAreaShape.values()) {
            map.put(shape, getNode(shape));
        }        
        
        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        typeComboBox.setItems(model.getSubAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedSubAreaType());
        typeComboBox.setDisable(model.getSubAreaTypes().size() <= 1);
        shapeComboBox.setItems(model.getShapes());
        shapeComboBox.getSelectionModel().select(model.getSelectedSubAreaShape());

        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new SubAreaTypeChangeAdapter(model, shapeComboBox));
        shapeComboBox.getSelectionModel().selectedItemProperty().addListener(new SubAreaShapeChangeAdapter(model, measurementTab, map));

    }
    
    private Node getNode(SubAreaShape shape) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getMeasurementDataModel().getFxmlPath(shape)));
            Node node = (AnchorPane) loader.load();
            AbstractComponentsFXMLController<SubAreaMeasurementDataModel> controller = loader.getController();
            controller.setModel(model.getMeasurementDataModel());
            controller.initializeComponents();
            return node;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }    
}
