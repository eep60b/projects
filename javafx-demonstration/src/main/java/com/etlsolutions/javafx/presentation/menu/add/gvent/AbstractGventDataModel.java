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
        this.types = new ObservableListWrapperA<>();
    }

    public AbstractGventDataModel(Gvent gvent) {
        this.notifications = new ObservableListWrapperA<>();
        this.types = new ObservableListWrapperA<>();
        this.gvent = gvent;
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
    public String getFxmlPath() {
        return "/log/GventFXML.fxml";
    }

    public GventDetailDataModel<GventDetail> getTypeDataModel(GventType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public GventDetailDataModel getDetailDataModel() {
        return detailDataModel;
    }
    
    
}
