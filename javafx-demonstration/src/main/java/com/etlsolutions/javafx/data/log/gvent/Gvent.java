package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.gwise.data.log.gvent.GventType;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.gwise.data.log.Notification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(name = "CustomGvent", value = CustomGvent.class),
    @JsonSubTypes.Type(name = "FloweringGvent", value = FloweringGvent.class),
    @JsonSubTypes.Type(name = "FruitingGvent", value = FruitingGvent.class)
})
public abstract class Gvent extends Log {

    private ObservableListWrapperA<Notification> notifications;
    private LocalDateTime endTime;

    public Gvent() {
    }

    public Gvent(DataUnitValueWrapper valueWrapper, GventDetailValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper.getStartTimeValueWrapper().getValue());
        this.notifications = new ObservableListWrapperA<>(detailValueWrapper.getNotifications());
        this.endTime = detailValueWrapper.getEndTimeValueWrapper().getValue();
    }

    @JsonIgnore
    public abstract GventType getType();
    
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
