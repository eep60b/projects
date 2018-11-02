package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.ComponentsFXMLControllerNodeWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import static com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.*;
import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
    
    @FXML
    private CheckBox repeatYearlyCheckBox;
    
    @FXML
    private ListView<Notification> notificationListView;
    
    @FXML
    private Button addNotificationButton;
    
    @FXML
    private Button editNotificationButton;
    
    @FXML
    private Button removeNotificationButton;    

    private final Map<GventType, ComponentsFXMLControllerNodeWrapper<GventDetailDataModel>> map = new HashMap<>();

    @Override
    public void initializeComponents() {
        try {
            for (GventType type : GventType.values()) {
                if (type != GventType.CUSTOM) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getDetailDataModel(type).getFxmlPath()));
                    Node node = (AnchorPane) loader.load();
                    AbstractComponentsFXMLController<GventDetailDataModel> controller = loader.getController();
                    controller.setModel(model.getDetailDataModel(type));
                    controller.initializeComponents();
                    map.put(type, new ComponentsFXMLControllerNodeWrapper<>(controller, node));
                }
            }

            initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

            DateTimePicker startTimePicker = new DateTimePicker();
            startTimePicker.setDateTimeValue(model.getStartTime());
            DateTimePicker endTimePicker = new DateTimePicker();
            endTimePicker.setDateTimeValue(model.getEndTime());
            startTimeHbox.getChildren().add(startTimePicker);
            endTimeHbox.getChildren().add(endTimePicker);

            typeComboBox.setItems(model.getTypes());
            GventType type = model.getSelectedType();
            typeComboBox.getSelectionModel().select(type);
            switch (type) {
                case CUSTOM:
                    mainTabPane.getTabs().remove(detailTab);
                    break;
                case FLOWERING:
                case FRUITING:
                    if (!mainTabPane.getTabs().contains(detailTab)) {
                        mainTabPane.getTabs().add(1, detailTab);
                    }
                    detailTab.setContent(map.get(type).getNode());
                    break;
                default:
                    throw new IllegalArgumentException("Ivalid gvent type.");
            }
            
            notificationListView.setItems(model.getNotifications());
            notificationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            notificationListView.getSelectionModel().select(model.getSelectedNotification());
            
            boolean hasNoSelectedNotification = model.getSelectedNotification() == null;
            editNotificationButton.setDisable(hasNoSelectedNotification);
            removeNotificationButton.setDisable(hasNoSelectedNotification);
            
            //Add listeners to components
            startTimePicker.dateTimeValueProperty().addListener(new StartTimeChangeAdapter(model));
            endTimePicker.dateTimeValueProperty().addListener(new EndTimeChangeAdapter(model));
            typeComboBox.getSelectionModel().selectedItemProperty().addListener(new GventTypeSelectionAdapter(model));
            notificationListView.getSelectionModel().selectedItemProperty().addListener(new SelectedNotificationChangeAdapter(model));
            addNotificationButton.setOnAction(new AddGventNotificationEventHandler(model));
            editNotificationButton.setOnAction(new EditGventNotificationEventHandler(model));
            removeNotificationButton.setOnAction(new RemoveEventHandler(model, NOTIFICATION_REMOVE_EVENT_ID));
            
            //Add losteners to data model.
            model.addPropertyChangeListener(SELECTED_TYPE_PROPERTY, new SelectedTypePropertyAdapter(mainTabPane, detailTab, map));
            model.getNotifications().addListener(new NotificationListChangeAdapter(model, notificationListView));
            model.addPropertyChangeListener(SELECTED_NOTIFICATION_PROPERTY, new SelectedNotificationPropertyChangeAdapter(notificationListView, editNotificationButton, removeNotificationButton));

        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

}
