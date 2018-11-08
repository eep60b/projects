package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.ComponentsFXMLControllerNodeWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import static com.etlsolutions.javafx.presentation.log.task.AbstractTaskDataModel.*;
import static com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_NOTIFICATION_PROPERTY;
import static com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY;
import com.etlsolutions.javafx.presentation.log.AddNotificationEventHandler;
import com.etlsolutions.javafx.presentation.log.EditNotificationEventHandler;
import com.etlsolutions.javafx.presentation.log.NotificationListChangeAdapter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.SelectedNotificationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
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
public class TaskFXMLController extends DataUnitFXMLController<Task, AbstractTaskDataModel> {

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
    private ComboBox<TaskType> typeComboBox;

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

    private final Map<TaskType, ComponentsFXMLControllerNodeWrapper<TaskDetailDataModel>> map = new HashMap<>();

    @Override
    public void initializeComponents() {
        try {
            for (TaskType type : TaskType.values()) {
                if (type != TaskType.CUSTOM) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getDetailDataModel(type).getFxmlPath()));
                    Node node = (AnchorPane) loader.load();
                    AbstractComponentsFXMLController<TaskDetailDataModel> controller = loader.getController();
                    controller.setModel(model.getDetailDataModel(type));
                    controller.initializeComponents();
                    map.put(type, new ComponentsFXMLControllerNodeWrapper<>(controller, node));
                }
            }

            initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

            DateTimePicker startTimePicker = new DateTimePicker();
            startTimePicker.setDateTimeValue(model.getStartTime().getValue());
            DateTimePicker endTimePicker = new DateTimePicker();
            endTimePicker.setDateTimeValue(model.getEndTime().getValue());
            startTimeHbox.getChildren().add(startTimePicker);
            endTimeHbox.getChildren().add(endTimePicker);

            typeComboBox.setItems(model.getTypes());
            TaskType type = model.getSelectedType().getValue();
            typeComboBox.getSelectionModel().select(type);
            switch (type) {
                case CUSTOM:
                    mainTabPane.getTabs().remove(detailTab);
                    break;
                case FERTILZATION:
                case HARVESTING:
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
            notificationListView.getSelectionModel().select(model.getSelectedNotification().getValue());
            
            boolean hasNoSelectedNotification = model.getSelectedNotification() == null;
            editNotificationButton.setDisable(hasNoSelectedNotification);
            removeNotificationButton.setDisable(hasNoSelectedNotification);
            
            //Add listeners to components
            startTimePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getStartTime()));
            endTimePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getEndTime()));
            typeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedType()));
            notificationListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedNotification()));
            addNotificationButton.setOnAction(new AddNotificationEventHandler(model));
            editNotificationButton.setOnAction(new EditNotificationEventHandler(model));
            removeNotificationButton.setOnAction(new RemoveEventHandler(model, NOTIFICATION_REMOVE_EVENT_ID));
            
            //Add losteners to data model.
            model.getSelectedType().addPropertyChangeListener(SELECTED_TYPE_PROPERTY, new SelectedTaskTypePropertyAdapter(mainTabPane, detailTab, map));
            model.getNotifications().addListener(new NotificationListChangeAdapter(model, notificationListView));
            model.addPropertyChangeListener(SELECTED_NOTIFICATION_PROPERTY, new SelectedNotificationPropertyChangeAdapter(notificationListView, editNotificationButton, removeNotificationButton));

        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

}