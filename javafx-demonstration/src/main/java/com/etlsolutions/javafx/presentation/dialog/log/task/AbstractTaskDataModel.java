package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.log.task.TaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.DetailDataModelGenerator;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
import com.etlsolutions.gwise.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.dialog.log.Notifiable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public abstract class AbstractTaskDataModel extends DataUnitFXMLDataModel<Task> implements Notifiable, FXMLContentActionDataModel {

    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY";
    public static final String SELECTED_NOTIFICATION_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_NOTIFICATION_PROPERTY";

    public static final RemoveEventId NOTIFICATION_REMOVE_EVENT_ID = new RemoveEventId(AbstractTaskDataModel.class.getName() + "NOTIFICATION_REMOVE_EVENT_ID", "remove notification");

    private final TaskValueWrapper valueWrapper;

    private final ObservableListWrapperA<TaskType> types;
    protected ValueWrapper<TaskType> selectedType;
    protected ValueWrapper<LocalDateTime> endTimeValueWrapper;
    private ValueWrapper<Notification> selectedNotification;

    protected TaskDetailDataModel detailDataModel;

    public AbstractTaskDataModel() {
        valueWrapper = LogFactory.getInstance().getDefaultFertilisationTaskValueWrapper();
        this.types = new ObservableListWrapperA<>(TaskType.values());
        selectedType = new ValueWrapper<>(types.get(0));
        endTimeValueWrapper = new ValueWrapper<>(null);
        selectedNotification = new ValueWrapper<>(null);
        detailDataModel = DetailDataModelGenerator.getInstance().getDetailDataModel(selectedType.getValue());
    }

    public AbstractTaskDataModel(Task task) {
        set(task);
        valueWrapper = LogFactory.getInstance().getTaskValueWrapper(task);
        types = new ObservableListWrapperA<>(task.getType());
        selectedType = new ValueWrapper<>(task.getType());
        detailDataModel = DetailDataModelGenerator.getInstance().getDetailDataModel(selectedType.getValue());
    }

    public ObservableListWrapperA<TaskType> getTypes() {
        return types;
    }

    public ValueWrapper<TaskType> getSelectedTypeValueWrapper() {
        return selectedType;
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return valueWrapper.getStartTimeValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return endTimeValueWrapper;
    }

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return valueWrapper.getNotifications();
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

    @Override
    public void remove(RemoveEventId id) {

        ObservableListWrapperA<Notification> notifications = getNotifications();
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

    @Override
    public TaskDetailDataModel getContentModel() {
        return detailDataModel;
    }

    @Override
    public void setContentModel(FXMLActionDataModel detailDataModel) {
        this.detailDataModel = (TaskDetailDataModel) detailDataModel;
    }

    @Override
    protected TaskValueWrapper getValueWrapper() {
        return valueWrapper;
    }
}
