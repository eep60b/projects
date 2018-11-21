package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AreaFXMLController extends DataUnitFXMLController<Area, AbstractAreaDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<AreaType> typeComboBox;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<MeasurementType> shapeComboBox;

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

    /**
     * Initialises the components in this dialog.
     *
     * @throws java.lang.Exception
     */
    @Override
    public void initializeComponents() throws Exception {

        Map<MeasurementType, Node> map = new HashMap<>();
        NodeGenerator nodeGenerator = new NodeGenerator(model, map);
        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        typeComboBox.setItems(model.getAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedAreaTypeValueWrapper().getValue());
        typeComboBox.setDisable(model.getAreaTypes().size() <= 1);
        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedAreaTypeValueWrapper()));

        ValueWrapper<MeasurementType> typeValueWrapper = model.getMeasurementDataModelValueWrapper().getValue().getMeasurementValueWrapper().getTypeValueWrapper();
        measurementTab.setContent(nodeGenerator.getNode(typeValueWrapper.getValue()));
        shapeComboBox.setItems(model.getAreaShapes());
        shapeComboBox.getSelectionModel().select(typeValueWrapper.getValue());
        shapeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(typeValueWrapper));
        typeValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AreaShapePropertyChangeAdapter(nodeGenerator, measurementTab));

        longitudeTextField.setText(String.valueOf(model.getAreaValueWrapper().getLongitudeValueWrapper().getValue()));
        longitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        longitudeTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAreaValueWrapper().getLongitudeValueWrapper()));
        
        latitudeTextField.setText(String.valueOf(model.getAreaValueWrapper().getLatitudeValueWrapper().getValue()));
        latitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        latitudeTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAreaValueWrapper().getLatitudeValueWrapper()));
        
        subAreaListView.setItems(model.getSubAreas());
        subAreaListView.getSelectionModel().select(model.getSelectedSubArea().getValue());
        removeSubAreaButton.setDisable(model.getSelectedSubArea().getValue() == null);
        editSubAreaButton.setDisable(model.getSelectedSubArea().getValue() == null);

        subAreaListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedSubArea()));
        addSubAreaButton.setOnAction(new AddSubAreaEventHandler(model, subAreaListView));
        removeSubAreaButton.setOnAction(new RemoveEventHandler(model, AbstractAreaDataModel.SELECTED_SUB_AREA_REMOVE_EVENT_ID));
        editSubAreaButton.setOnAction(new EditSubAreaEventHandler(model));
    }
}
