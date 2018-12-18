package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.area.AddAreaDataModel;
import com.etlsolutions.javafx.presentation.area.EditAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.AddSubAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.EditSubAreaDataModel;
import static com.etlsolutions.javafx.presentation.area.subarea.location.AddLocationDataModel.*;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
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
public class LocationFXMLController extends DataUnitFXMLController<Location, AbstractLocationDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

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

    @FXML
    private ComboBox<Area> areaComboBox;

    @FXML
    private Button addAreaButton;

    @FXML
    private Button removeAreaButton;

    @FXML
    private Button editAreaButton;

    @FXML
    private ComboBox<SubArea> subAreaComboBox;

    @FXML
    private Button addSubAreaButton;

    @FXML
    private Button removeSubAreaButton;

    @FXML
    private Button editSubAreaButton;

    @FXML
    private ComboBox<LocationType> locationTypeComboBox;

    @FXML
    private Tab measurementTab;

    @Override
    public void initializeComponents() throws Exception {

        Map<LocationMeasurementType, Node> map = new HashMap<>();
        NodeGenerator nodeGenerator = new NodeGenerator(model, map);

        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        areaComboBox.setItems(model.getAreas());
        areaComboBox.getSelectionModel().select(model.getSelectedAreaValueWrapper().getValue());
        removeAreaButton.setDisable(model.getAreas().size() <= 1);
        editAreaButton.setDisable(model.getAreas().size() < 1);
        subAreaComboBox.setItems(model.getSubAreas());
        subAreaComboBox.getSelectionModel().select(model.getSelectedSubAreaValueWrapper().getValue());
        removeSubAreaButton.setDisable(model.getSubAreas().size() <= 1);
        editSubAreaButton.setDisable(model.getSubAreas().size() < 1);

        locationTypeComboBox.setItems(model.getTypes());
        locationTypeComboBox.getSelectionModel().select(model.getLocationValueWrapper().getTypeValueWrapper().getValue());

        measurementTab.setContent(nodeGenerator.getNode((LocationMeasurementType)model.getMeasurementDataModelValueWrapper().getValue().getTypeValueWrapper().getValue()));

        areaComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedAreaValueWrapper()));
        addAreaButton.setOnAction(new AddItemEventHandler<>(model.getAreas(), model.getSelectedAreaValueWrapper(), new AddAreaDataModel()));
        removeAreaButton.setOnAction(new RemoveEventHandler(model, SELECTED_AREA_REMOVE_EVENT_ID));
        editAreaButton.setOnAction(new EditItemEventHandler<>(new EditAreaDataModel(model.getSelectedAreaValueWrapper().getValue())));
        subAreaComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedSubAreaValueWrapper()));
        addSubAreaButton.setOnAction(new AddItemEventHandler<>(model.getSubAreas(), model.getSelectedSubAreaValueWrapper(), new AddSubAreaDataModel(model.getSelectedAreaValueWrapper().getValue())));
        removeSubAreaButton.setOnAction(new RemoveEventHandler(model, SELECTED_SUBAREA_REMOVE_EVENT_ID));
        editSubAreaButton.setOnAction(new EditSubAreaForLocationEventHandler(model));
        locationTypeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>( model.getMeasurementDataModelValueWrapper().getValue().getTypeValueWrapper()));

        model.getAreas().addListener(new AreaListChangeAdapter(areaComboBox, removeAreaButton, editAreaButton, model));
        model.getSelectedAreaValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AreaSelectionPropertyChangeAdapter(model, subAreaComboBox));
        model.getSubAreas().addListener(new SubAreaListChangeAdapter(subAreaComboBox, removeSubAreaButton, editSubAreaButton, model));
        model.getSelectedSubAreaValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new SubAreaSelectionPropertyChangeAdapter(model, locationTypeComboBox));
        model.getTypes().addListener(new LocationTypeListChangeAdapter(locationTypeComboBox, model));
        model.getLocationValueWrapper().getTypeValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new LocationTypePropertyChangeAdaper(model, okButton, errorMessageLabel, measurementTab, nodeGenerator));

    }

}
