package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.gvent.GventDetail;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractGventDataModel extends DataUnitFXMLDataModel {

    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY";
    
    protected Gvent gvent;
    private final ObservableListWrapperA<GventType> types;
    protected GventType selectedType;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected final ObservableListWrapperA<Notification> notifications;
    private Notification selectedNotification;
    protected GventDetailDataModel detailDataModel;

    public AbstractGventDataModel() {
        this.notifications = new ObservableListWrapperA<>();
        this.types = new ObservableListWrapperA<>(GventType.values());
        selectedType = types.get(0);
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
        this.selectedType = selectedType;
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
        this.selectedNotification = selectedNotification;
    }
     
    public Gvent getGvent() {
        return gvent;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/GventFXML.fxml";
    }

    public GventDetailDataModel<GventDetail> getTypeDataModel(GventType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public GventDetailDataModel getDetailDataModel() {
        return detailDataModel;
    }
    
    
}
