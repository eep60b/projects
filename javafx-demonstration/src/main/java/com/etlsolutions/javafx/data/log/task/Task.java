package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.Notification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * @author zc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(name = "CustomTask", value = CustomTask.class),
    @JsonSubTypes.Type(name = "FertilisationTask", value = FertilisationTask.class),
    @JsonSubTypes.Type(name = "HarvestingTask", value = HarvestingTask.class),
    @JsonSubTypes.Type(name = "PlantThinningTask", value = PlantThinningTask.class),
    @JsonSubTypes.Type(name = "PruningTask", value = PruningTask.class),
    @JsonSubTypes.Type(name = "TransplantTask", value = TransplantTask.class),
    @JsonSubTypes.Type(name = "WateringTask", value = WateringTask.class)
})
public abstract class Task extends Log {

    private ObservableListWrapperA<Notification> notifications;

    public Task() {
    }

    public Task(DataUnitValueWrapper valueWrapper, TaskValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper.getStartTime());
        this.notifications = new ObservableListWrapperA<>(detailValueWrapper.getNotifications());
    }

    @JsonIgnore
    public abstract TaskType getType();

    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ObservableListWrapperA<Notification> notifications) {
        this.notifications = notifications;
    }
}
