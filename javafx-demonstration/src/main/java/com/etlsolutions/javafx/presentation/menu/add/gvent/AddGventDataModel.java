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
public class AddGventDataModel extends DataUnitFXMLDataModel {

    protected Gvent gvent;
    private final ObservableListWrapperA<GventType> types;
    protected GventType selectedType;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected final ObservableListWrapperA<Notification> notifications;
    private Notification selectedNotification;
    protected GventDetail detail;

    public AddGventDataModel() {
        this.notifications = new ObservableListWrapperA<>();
        this.types = new ObservableListWrapperA<>();
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
    
    
    
    public Gvent getGvent() {
        return gvent;
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/GventFXML.fxml";
    }
}
