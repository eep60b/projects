package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.task.FertilisationTaskDetail;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.log.Notifiable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public abstract class AbstractTaskDataModel extends DataUnitFXMLDataModel implements Notifiable{

    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY";
    public static final String SELECTED_NOTIFICATION_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_NOTIFICATION_PROPERTY";

    public static final RemoveEventId NOTIFICATION_REMOVE_EVENT_ID = new RemoveEventId(AbstractTaskDataModel.class.getName() + "NOTIFICATION_REMOVE_EVENT_ID", "remove notification");

    protected Task task;
    private final ObservableListWrapperA<TaskType> types;
    protected ValueWrapper<TaskType> selectedType;
    protected ValueWrapper<LocalDateTime> startTime;
    protected ValueWrapper<LocalDateTime> endTime;
    protected final ObservableListWrapperA<Notification> notifications;
    private ValueWrapper<Notification> selectedNotification;

    protected TaskDetailDataModel detailDataModel;

    public AbstractTaskDataModel() {
        this.notifications = new ObservableListWrapperA<>();
        this.types = new ObservableListWrapperA<>(TaskType.values());
        selectedType = new ValueWrapper<>(types.get(0));
        detailDataModel = getDetailDataModel(selectedType.getValue());
    }

    public AbstractTaskDataModel(Task task) {
        this.notifications = new ObservableListWrapperA<>(task.getNotifications());
        types = new ObservableListWrapperA<>(task.getType());
        selectedType = new ValueWrapper<>(task.getType());
        this.task = task;
        detailDataModel = getDetailDataModel(selectedType.getValue());
    }

    public ObservableListWrapperA<TaskType> getTypes() {
        return types;
    }

    public ValueWrapper<TaskType> getSelectedType() {
        return selectedType;
    }

    public ValueWrapper<LocalDateTime> getStartTime() {
        return startTime;
    }

    public ValueWrapper<LocalDateTime> getEndTime() {
        return endTime;
    }

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public ValueWrapper<Notification> getSelectedNotification() {
        return selectedNotification;
    }

    public TaskDetailDataModel getDetailDataModel() {
        return detailDataModel;
    }

    public void setDetailDataModel(TaskDetailDataModel detailDataModel) {
        this.detailDataModel = detailDataModel;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (Objects.equals(id, NOTIFICATION_REMOVE_EVENT_ID)) {

            int index = notifications.indexOf(selectedNotification.getValue());
            notifications.remove(index);
            index = index == notifications.size() ? index - 1 : index;
            selectedNotification.setValue(notifications.get(index));
            return;
        }

        detailDataModel.remove(id);

        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/TaskFXML.fxml";
    }

    public final TaskDetailDataModel getDetailDataModel(TaskType type) {
        switch (type) {
            case CUSTOM:
                return null;
            case FERTILZATION:
                return new FertilisationTaskDetailDataModel(
                        new FertilisationTaskDetail(FertiliserFactory.getInstance().getDefaultFertiliser(), 0.0, "growmore"));
            default:
                return null;
        }
    }
}
