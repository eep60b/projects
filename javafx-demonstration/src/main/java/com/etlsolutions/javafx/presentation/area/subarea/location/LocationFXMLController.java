package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.area.AddAreaDataModel;
import com.etlsolutions.javafx.presentation.area.EditAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.AddSubAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.EditSubAreaDataModel;
import static com.etlsolutions.javafx.presentation.area.subarea.location.AddLocationDataModel.*;
import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
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
import org.apache.log4j.Logger;

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
    private ComboBox<SubArea> subareaComboBox;

    @FXML
    private Button addSubareaButton;

    @FXML
    private Button removeSubareaButton;

    @FXML
    private Button editSubareaButton;

    @FXML
    private ComboBox<LocationType> locationTypeComboBox;

    @FXML
    private Tab measurementTab;

    private final Map<LocationMeasurementType, Node> map = new HashMap<>();

    @Override
    public void initializeComponents() {

        try {

            for (LocationMeasurementType type : LocationMeasurementType.values()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getMeasurementDataModel(type).getFxmlPath()));
                Node node = (AnchorPane) loader.load();
                AbstractComponentsFXMLController<LocationMeasurementDataModel> controller = loader.getController();
                controller.setModel(model.getMeasurementDataModel());
                controller.initializeComponents();
                map.put(type, node);
            }

            initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

            areaComboBox.setItems(model.getAreas());
            areaComboBox.getSelectionModel().select(model.getSelectedArea());
            removeAreaButton.setDisable(model.getAreas().size() <= 1);
            editAreaButton.setDisable(model.getAreas().size() < 1);
            subareaComboBox.setItems(model.getSubAreas());
            subareaComboBox.getSelectionModel().select(model.getSelectedSubArea());
            removeSubareaButton.setDisable(model.getSubAreas().size() <= 1);
            editSubareaButton.setDisable(model.getSubAreas().size() < 1);

            locationTypeComboBox.setItems(model.getTypes());
            locationTypeComboBox.getSelectionModel().select(model.getSelectedType());

            measurementTab.setContent(map.get(model.getMeasurementDataModel().getType()));

            areaComboBox.getSelectionModel().selectedItemProperty().addListener(new AreaSelectionChangeAdaper(model));
            addAreaButton.setOnAction(new LocationAreaEventHandler(model, new AddAreaDataModel()));
            removeAreaButton.setOnAction(new RemoveEventHandler(model, SELECTED_AREA_REMOVE_EVENT_ID));
            editAreaButton.setOnAction(new LocationAreaEventHandler(model, new EditAreaDataModel(model.getSelectedArea())));
            subareaComboBox.getSelectionModel().selectedItemProperty().addListener(new SubAreaSelectionChangeAdaper(model, locationTypeComboBox));
            addSubareaButton.setOnAction(new LocationSubAreaEventHandler(model, new AddSubAreaDataModel(model.getSelectedArea())));
            removeSubareaButton.setOnAction(new RemoveEventHandler(model, SELECTED_SUBAREA_REMOVE_EVENT_ID));
            editSubareaButton.setOnAction(new LocationSubAreaEventHandler(model, new EditSubAreaDataModel(model.getSelectedArea(), model.getSelectedSubArea())));
            locationTypeComboBox.getSelectionModel().selectedItemProperty().addListener(new LocationTypeSelectionChangeAdaper(model));
            
            model.getAreas().addListener(new AreaListChangeAdapter(areaComboBox, removeAreaButton, editAreaButton, model));
            model.addPropertyChangeListener(SELECTED_AREA_PROPERTY, new AreaSelectionPropertyChangeAdapter(subareaComboBox));
            model.getSubAreas().addListener(new SubAreaListChangeAdapter(subareaComboBox, removeSubareaButton, editSubareaButton, model));
            model.addPropertyChangeListener(SELECTED_SUBAREA_PROPERTY, new SubAreaSelectionPropertyChangeAdapter(locationTypeComboBox));
            model.getTypes().addListener(new LocationTypeListChangeAdapter(locationTypeComboBox, model));
            model.addPropertyChangeListener(SELECTED_TYPE_PROPERTY, new LocationTypePropertyChangeAdaper(okButton, errorMessageLabel, measurementTab, map));

        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

}
