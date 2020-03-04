package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.NodeGenerator;
import com.etlsolutions.javafx.presentation.NodeWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import static com.etlsolutions.javafx.presentation.dialog.log.task.AbstractTaskDataModel.*;
import com.etlsolutions.javafx.presentation.dialog.log.AddNotificationEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.EditNotificationEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.NotificationListChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.SelectedNotificationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

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
    private CheckBox repeatCheckBox;
    
    @FXML
    private ComboBox repeatComboBox;

    @FXML
    private ListView<Notification> notificationListView;

    @FXML
    private Button addNotificationButton;

    @FXML
    private Button editNotificationButton;

    @FXML
    private Button removeNotificationButton;

    @Override
    public void initializeComponents() throws Exception {

        Map<TaskType, NodeWrapper> map = new HashMap<>();
        NodeGenerator<AbstractTaskDataModel, TaskType> generator = new NodeGenerator<>(model, map);
        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        DateTimePicker startTimePicker = new DateTimePicker();
        startTimePicker.setDateTimeValue(model.getStartTimeValueWrapper().getValue());
        DateTimePicker endTimePicker = new DateTimePicker();
        endTimePicker.setDateTimeValue(model.getEndTimeValueWrapper().getValue());
        startTimeHbox.getChildren().add(startTimePicker);
        endTimeHbox.getChildren().add(endTimePicker);

        typeComboBox.setItems(model.getTypes());
        TaskType type = model.getSelectedTypeValueWrapper().getValue();
        typeComboBox.getSelectionModel().select(type);
        SelectedTypePropertyAdapter adapter = new SelectedTypePropertyAdapter(model, mainTabPane, detailTab, generator);
        adapter.process(model.getSelectedTypeValueWrapper());
        model.getSelectedTypeValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, adapter);

        notificationListView.setItems(model.getNotifications());
        notificationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        notificationListView.getSelectionModel().select(model.getSelectedNotification().getValue());

        boolean hasNoSelectedNotification = model.getSelectedNotification() == null;
        editNotificationButton.setDisable(hasNoSelectedNotification);
        removeNotificationButton.setDisable(hasNoSelectedNotification);

        //Add listeners to components
        startTimePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getStartTimeValueWrapper()));
        endTimePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getEndTimeValueWrapper()));
        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedTypeValueWrapper()));
        notificationListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedNotification()));
        addNotificationButton.setOnAction(new AddNotificationEventHandler(model));
        editNotificationButton.setOnAction(new EditNotificationEventHandler(model));
        removeNotificationButton.setOnAction(new RemoveEventHandler(model, NOTIFICATION_REMOVE_EVENT_ID));

        //Add losteners to data model.

        model.getNotifications().addListener(new NotificationListChangeAdapter(model, notificationListView));
        model.getSelectedNotification().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new SelectedNotificationPropertyChangeAdapter(model, notificationListView, editNotificationButton, removeNotificationButton));
    }
}
