package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DateTimePicker;
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
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import org.apache.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class GventFXMLController extends DataUnitFXMLController<AbstractGventDataModel> {

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
    private TabPane mainTabPane;

    @FXML
    private ComboBox<GventType> typeComboBox;

    @FXML
    private Tab detailTab;

    @FXML
    private HBox startTimeHbox;

    @FXML
    private HBox endTimeHbox;

    private final Map<GventType, Node> map = new HashMap<>();

    @Override
    public void initializeComponents() {
        try {
            for (GventType type : GventType.values()) {
                if (type != GventType.CUSTOM) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getTypeDataModel(type).getFxmlPath()));
                    Node node = (AnchorPane) loader.load();
                    AbstractComponentsFXMLController<GventDetailDataModel> controller = loader.getController();
                    controller.setModel(model.getDetailDataModel());
                    controller.initializeComponents();
                    map.put(type, node);
                }
            }

            initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

            DateTimePicker startTimePicker = new DateTimePicker();
            startTimePicker.setDateTimeValue(model.getStartTime());
            DateTimePicker endTimePicker = new DateTimePicker();
            endTimePicker.setDateTimeValue(model.getEndTime());
            startTimeHbox.getChildren().addAll(startTimePicker);
            endTimeHbox.getChildren().addAll(endTimePicker);

        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

}
