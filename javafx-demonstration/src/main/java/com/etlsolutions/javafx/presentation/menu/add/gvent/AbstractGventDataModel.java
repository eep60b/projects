package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.gvent.FloweringGventDetail;
import com.etlsolutions.javafx.data.log.gvent.FruitingGventDetail;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.gvent.GventDetail;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author zc
 */
public abstract class AbstractGventDataModel extends DataUnitFXMLDataModel {

    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY";
    public static final String SELECTED_NOTIFICATION_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_NOTIFICATION_PROPERTY";

    public static final RemoveEventId NOTIFICATION_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.NOTIFICATION_REMOVE_EVENT_ID", "remove notification");    
    
    protected Gvent gvent;
    private final ObservableListWrapperA<GventType> types;
    protected GventType selectedType;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected final ObservableListWrapperA<Notification> notifications;
    private Notification selectedNotification;
    protected GventDetail detail;
    private GventDetailDataModel detailDataModel;


    public AbstractGventDataModel() {
        this.notifications = new ObservableListWrapperA<>();
        this.types = new ObservableListWrapperA<>(GventType.values());
        selectedType = types.get(0);
        detail = new FloweringGventDetail();
    }

    public AbstractGventDataModel(Gvent gvent) {
        this.notifications = new ObservableListWrapperA<>(gvent.getNotifications());
        types = new ObservableListWrapperA<>(gvent.getType());
        selectedType = gvent.getType();
        this.gvent = gvent;
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

    public Gvent getGvent() {
        return gvent;
    }

    @Override
    public void remove(RemoveEventId id) {
        
        if(Objects.equals(id, NOTIFICATION_REMOVE_EVENT_ID)) {
            notifications.remove(selectedNotification);
        }
        
        super.remove(id);
    }

    
    
    @Override
    public String getFxmlPath() {
        return "/fxml/log/GventFXML.fxml";
    }

    public GventDetailDataModel getTypeDataModel(GventType type) {
        switch (type) {
            case FLOWERING:
                return new FloweringGventDetailDataModel(new FloweringGventDetail());
            case FRUITING:
                return new FruitingGventDetailDataModel(new FruitingGventDetail());
            default:
                return null;
        }
    }

    public GventDetailDataModel getDetailDataModel() {
        return detailDataModel;
    }
}
