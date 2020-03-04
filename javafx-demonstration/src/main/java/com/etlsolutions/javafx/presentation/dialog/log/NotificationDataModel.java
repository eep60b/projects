package com.etlsolutions.javafx.presentation.dialog.log;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.log.NotificationTimeUnit;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.Savable;

/**
 *
 * @author zc
 */
public class NotificationDataModel implements FXMLActionDataModel, Savable {

    private Notification notification;

    private int lengthBefore;       //How many minutes or days before the task or event start time.
    private final ObservableListWrapperA<NotificationTimeUnit> timeUnits;    
    private NotificationTimeUnit selectedTimeUnit;
    private int repeatTimes; // Start from 1 but -1 is infinitive.
    private boolean saved;

    public NotificationDataModel() {
        this(LogFactory.getInstance().getDefaultNotification());
    }

    public NotificationDataModel(Notification notification) {
        this.notification = notification;
        lengthBefore = notification.getLengthBefore();
        selectedTimeUnit = notification.getTimeUnit();
        repeatTimes = notification.getRepeatTimes();
        timeUnits = new ObservableListWrapperA<>(NotificationTimeUnit.values());
    }

    public Notification getNotification() {
        return notification;
    }

    public int getLengthBefore() {
        return lengthBefore;
    }

    public void setLengthBefore(int lengthBefore) {
        this.lengthBefore = lengthBefore;
    }

    public ObservableListWrapperA<NotificationTimeUnit> getTimeUnits() {
        return timeUnits;
    }
    
    public NotificationTimeUnit getSelectedTimeUnit() {
        return selectedTimeUnit;
    }

    public void setSelectedTimeUnit(NotificationTimeUnit selectedTimeUnit) {
        this.selectedTimeUnit = selectedTimeUnit;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public boolean isSaved() {
        return saved;
    }
    
    @Override
    public void save() {
        notification.setLengthBefore(lengthBefore);
        notification.setTimeUnit(selectedTimeUnit);
        notification.setRepeatTimes(repeatTimes);
        saved = true;
    }     
    
    @Override
    public String getFxmlPath() {
        return "/fxml/log/NotificationFXML.fxml";
    }
}
