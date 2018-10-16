package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import static com.etlsolutions.javafx.presentation.menu.add.location.AddLocationDataModel.*;
import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import org.apache.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddLocationFXMLController extends DataUnitFXMLController<AddLocationDataModel> {

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
    private Tab detailsTab;

    @Override
    public void initializeComponents() {

        try {
            
            initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

            areaComboBox.setItems(model.getAreas());
            areaComboBox.getSelectionModel().select(model.getSelectedArea());
            addAreaButton.setOnAction(new AddLocationAreaEventHandler(model));
            subareaComboBox.setItems(model.getSubAreas());
            subareaComboBox.getSelectionModel().select(model.getSelectedSubArea());
            locationTypeComboBox.setItems(model.getTypes());
            locationTypeComboBox.getSelectionModel().select(model.getSelectedType());
            locationTypeComboBox.setDisable(model.getTypes().size() <= 1);

            FXMLLoader groundLocationLoader = new FXMLLoader(getClass().getResource(model.getGroudLocationDeatailsFxmlPath()));
            Node groundLocationNode = (Node) groundLocationLoader.load();
            GroundLocationDetailFXMLController groundLocationDetailFXMLController = groundLocationLoader.getController();
            groundLocationDetailFXMLController.setModel(model);
            groundLocationDetailFXMLController.initializeComponents();

            FXMLLoader containerLoader = new FXMLLoader(getClass().getResource(model.getContainerFxmlPath()));
            Node containerNode = (Node) containerLoader.load();
            ContainerDetailFXMLController containerDetailFXMLController = containerLoader.getController();
            containerDetailFXMLController.setModel(model);
            containerDetailFXMLController.initializeComponents();

            switch (model.getSelectedType()) {
                case CONTAINER:
                    detailsTab.setContent(containerNode);
                    break;
                default:
                    detailsTab.setContent(groundLocationNode);
            }

            areaComboBox.selectionModelProperty().addListener(new AreaSelectionChangeAdaper(model));
            subareaComboBox.selectionModelProperty().addListener(new SubAreaSelectionChangeAdaper(model));
            locationTypeComboBox.selectionModelProperty().addListener(new LocationTypeSelectionChangeAdaper(model));

            model.addPropertyChangeListener(AREA_PROPERTY, new AreasPropertyChangeAdaper(subareaComboBox, removeAreaButton));
            model.addPropertyChangeListener(SUBAREA_PROPERTY, new SubAreasPropertyChangeAdaper(locationTypeComboBox, removeSubareaButton, editSubareaButton));
            model.addPropertyChangeListener(LOCATION_TYPE_PROPERTY, new LocationTypePropertyChangeAdaper(okButton, errorMessageLabel));
            
            model.getAreas().addListener(new AreaListChangeAdapter(areaComboBox, model));
            
        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

}
