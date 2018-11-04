package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.task.CustomTaskDetail;
import com.etlsolutions.javafx.data.log.task.FertilisationTaskDetail;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public abstract class AbstractTaskDataModel extends DataUnitFXMLDataModel {

    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY";
    public static final String SELECTED_NOTIFICATION_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_NOTIFICATION_PROPERTY";

    public static final RemoveEventId NOTIFICATION_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.NOTIFICATION_REMOVE_EVENT_ID", "remove notification");

    protected Task task;
    private final ObservableListWrapperA<TaskType> types;
    protected TaskType selectedType;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected final ObservableListWrapperA<Notification> notifications;
    private Notification selectedNotification;
 
    private TaskDetailDataModel detailDataModel;

    public AbstractTaskDataModel() {
        this.notifications = new ObservableListWrapperA<>();
        this.types = new ObservableListWrapperA<>(TaskType.values());
        selectedType = types.get(0);
        detailDataModel = getDetailDataModel(selectedType);
    }

    public AbstractTaskDataModel(Task task) {
        this.notifications = new ObservableListWrapperA<>(task.getNotifications());
        types = new ObservableListWrapperA<>(task.getType());
        selectedType = task.getType();
        this.task = task;
        detailDataModel = getDetailDataModel(selectedType);
    }

    public ObservableListWrapperA<TaskType> getTypes() {
        return types;
    }

    public TaskType getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(TaskType selectedType) {
        TaskType oldValue = this.selectedType;
        this.selectedType = selectedType;
        detailDataModel = getDetailDataModel(selectedType);
        support.firePropertyChange(SELECTED_TYPE_PROPERTY, oldValue, this.selectedType);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    public Notification getSelectedNotification() {
        return selectedNotification;
    }

    public void setSelectedNotification(Notification selectedNotification) {

        Notification oldValue = this.selectedNotification;
        this.selectedNotification = selectedNotification;
        support.firePropertyChange(SELECTED_NOTIFICATION_PROPERTY, oldValue, this.selectedNotification);
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
            notifications.remove(selectedNotification);
        }

        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/GventFXML.fxml";
    }

    public final TaskDetailDataModel getDetailDataModel(TaskType type) {
        switch (type) {
            case CUSTOM:
                return new CustomTaskDetailDataModel(new CustomTaskDetail());
            case FERTILZATION:
                return new FertilizationTaskDetailDataModel(
                        new FertilisationTaskDetail(FertiliserFactory.getInstance().getDefaultFertiliser(), 0.0, "growmore"));
            default:
                return null;
        }
    }
}