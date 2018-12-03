package com.etlsolutions.javafx.presentation.log.gvent;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.log.SelectedNotificationChangeAdapter;
import com.etlsolutions.javafx.presentation.log.NotificationListChangeAdapter;
import com.etlsolutions.javafx.presentation.log.AddNotificationEventHandler;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.NodeGenerator;
import com.etlsolutions.javafx.presentation.NodeWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.log.EditNotificationEventHandler;
import static com.etlsolutions.javafx.presentation.log.gvent.AbstractGventDataModel.*;
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
public class GventFXMLController extends DataUnitFXMLController<Gvent, AbstractGventDataModel> {

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

    @Override
    public void initializeComponents() throws Exception {

        Map<GventType, NodeWrapper> map = new HashMap<>();
        NodeGenerator<AbstractGventDataModel, GventType> generator = new NodeGenerator<>(model, map);
        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        DateTimePicker startTimePicker = new DateTimePicker();
        startTimePicker.setDateTimeValue(model.getStartTimeValueWrapper().getValue());
        DateTimePicker endTimePicker = new DateTimePicker();
        endTimePicker.setDateTimeValue(model.getEndTimeValueWrapper().getValue());
        startTimeHbox.getChildren().add(startTimePicker);
        endTimeHbox.getChildren().add(endTimePicker);

        repeatYearlyCheckBox.setSelected(true);
        
        typeComboBox.setItems(model.getTypes());
        GventType type = model.getSelectedTypeValueWrapper().getValue();
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
                detailTab.setContent(generator.getNode(model.getSelectedTypeValueWrapper().getValue()));
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
        startTimePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getStartTimeValueWrapper()));
        endTimePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getEndTimeValueWrapper()));
        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedTypeValueWrapper()));
        notificationListView.getSelectionModel().selectedItemProperty().addListener(new SelectedNotificationChangeAdapter(model));
        addNotificationButton.setOnAction(new AddNotificationEventHandler(model));
        editNotificationButton.setOnAction(new EditNotificationEventHandler(model));
        removeNotificationButton.setOnAction(new RemoveEventHandler(model, NOTIFICATION_REMOVE_EVENT_ID));

        //Add losteners to data model.
        model.getSelectedTypeValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new SelectedTypePropertyAdapter(mainTabPane, detailTab, generator));
        model.getNotifications().addListener(new NotificationListChangeAdapter(model, notificationListView));
        model.getSelectedNotification().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new SelectedNotificationPropertyChangeAdapter(model, notificationListView, editNotificationButton, removeNotificationButton));
    }

}
