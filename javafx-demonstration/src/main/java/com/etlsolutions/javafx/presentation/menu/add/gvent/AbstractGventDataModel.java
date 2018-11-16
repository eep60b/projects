package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.gvent.FloweringGventDetail;
import com.etlsolutions.javafx.data.log.gvent.FruitingGventDetail;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.log.Notifiable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author zc
 */
public abstract class AbstractGventDataModel extends DataUnitFXMLDataModel<Gvent> implements Notifiable {

    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY";
    public static final String SELECTED_NOTIFICATION_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_NOTIFICATION_PROPERTY";

    public static final RemoveEventId NOTIFICATION_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.NOTIFICATION_REMOVE_EVENT_ID", "remove notification");

    private final ObservableListWrapperA<GventType> types;
    protected GventType selectedType;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected final ObservableListWrapperA<Notification> notifications;
    private final ValueWrapper<Notification> selectedNotification;
 
    private GventDetailDataModel detailDataModel;

    public AbstractGventDataModel() {
        notifications = new ObservableListWrapperA<>();
        selectedNotification = new ValueWrapper<>(null);
        types = new ObservableListWrapperA<>(GventType.values());
        selectedType = types.get(0);
        detailDataModel = getDetailDataModel(selectedType);
    }

    public AbstractGventDataModel(Gvent gvent) {
        notifications = new ObservableListWrapperA<>(gvent.getNotifications());
        selectedNotification = new ValueWrapper<>(notifications.get(0));
        types = new ObservableListWrapperA<>(gvent.getType());
        selectedType = gvent.getType();
        dataUnit = gvent;
        detailDataModel = getDetailDataModel(selectedType);
    }

    public ObservableListWrapperA<GventType> getTypes() {
        return types;
    }

    public GventType getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(GventType selectedType) {
        GventType oldValue = this.selectedType;
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

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public ValueWrapper<Notification>  getSelectedNotification() {
        return selectedNotification;
    }

    public GventDetailDataModel getDetailDataModel() {
        return detailDataModel;
    }

    public void setDetailDataModel(GventDetailDataModel detailDataModel) {
        this.detailDataModel = detailDataModel;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (Objects.equals(id, NOTIFICATION_REMOVE_EVENT_ID)) {
            notifications.remove(selectedNotification.getValue());
        }

        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/GventFXML.fxml";
    }

    public final GventDetailDataModel getDetailDataModel(GventType type) {
        switch (type) {
            case FLOWERING:
                return new FloweringGventDetailDataModel(new FloweringGventDetail());
            case FRUITING:
                return new FruitingGventDetailDataModel(new FruitingGventDetail(1, "red", "round", 3, 3));
            default:
                return null;
        }
    }
}
