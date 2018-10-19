package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AreaFXMLController extends DataUnitFXMLController<AbstractAreaDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<AreaType> typeComboBox;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<AreaShape> shapeComboBox;

    @FXML
    private TextField longitudeTextField;

    @FXML
    private TextField latitudeTextField;

    @FXML
    private Tab measurementTab;

    @FXML
    private ListView<SubArea> subAreaListView;
    
    @FXML
    private Button addSubAreaButton;

    @FXML
    private Button editSubAreaButton;

    @FXML
    private Button removeSubAreaButton;

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

    private final Map<AreaShape, Node> map = new HashMap<>();

    /**
     * Initialises the components in this dialog.
     *
     */
    @Override
    public void initializeComponents() {

        for (AreaShape shape : AreaShape.values()) {
            map.put(shape, getNode(shape));
        }

        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        typeComboBox.setItems(model.getAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedAreaType());
        typeComboBox.setDisable(model.getAreaTypes().size() <= 1);
        shapeComboBox.setItems(model.getAreaShapes());
        shapeComboBox.getSelectionModel().select(model.getSelectedAreaShape());
        longitudeTextField.setText(String.valueOf(model.getLongitude()));
        longitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        latitudeTextField.setText(String.valueOf(model.getLatitude()));
        latitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        measurementTab.setContent(map.get(model.getSelectedAreaShape()));
        subAreaListView.setItems(model.getSubAreas());
        
        
        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new AreaTypeChangeAdapter(model, shapeComboBox));
        shapeComboBox.getSelectionModel().selectedItemProperty().addListener(new AreaShapeChangeAdapter(model, measurementTab, map));
        longitudeTextField.textProperty().addListener(new LongitudeChangeAdapter(model));
        latitudeTextField.textProperty().addListener(new LatitudeChangeAdapter(model));

    }

    private Node getNode(AreaShape shape) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getMeasurementDataModel().getFxmlPath(shape)));
            Node node = (AnchorPane) loader.load();
            AbstractComponentsFXMLController<AreaMeasurementDataModel> controller = loader.getController();
            controller.setModel(model.getMeasurementDataModel());
            controller.initializeComponents();
            return node;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
