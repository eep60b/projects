package com.etlsolutions.javafx.presentation.dialog.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.NodeGenerator;
import com.etlsolutions.javafx.presentation.dialog.area.AreaShapePropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
 * @author zc
 */
public class SubAreaFXMLController extends DataUnitFXMLController<SubArea, AbstractSubAreaDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<SubAreaType> typeComboBox;

    @FXML
    private ComboBox<MeasurementType> shapeComboBox;

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

        typeComboBox.setItems(model.getSubAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedSubAreaTypeValueWrapper().getValue());
        typeComboBox.setDisable(model.getSubAreaTypes().size() <= 1);
        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedSubAreaTypeValueWrapper()));

        ValueWrapper<MeasurementType> typeValueWrapper = model.getContentModel().getMeasurementValueWrapper().getTypeValueWrapper();
        measurementTab.setContent(nodeGenerator.getNode(typeValueWrapper.getValue()).getNode());
        shapeComboBox.setItems(model.getSubAreaShapes());
        shapeComboBox.getSelectionModel().select(typeValueWrapper.getValue());
        shapeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(typeValueWrapper));
        typeValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AreaShapePropertyChangeAdapter(model, nodeGenerator, measurementTab));
    }
}
