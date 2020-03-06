package com.etlsolutions.gwise.data.log.task;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.log.GwiseLogBean;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.log.task.CustomTask;
import com.etlsolutions.javafx.data.log.task.FertilisationTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.PlantThinningTask;
import com.etlsolutions.javafx.data.log.task.PruningTask;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.data.log.task.TransplantTask;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
import java.util.List;

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
public abstract class GwiseTaskBean extends GwiseLogBean {

    private List<Notification> notifications = new ArrayList<>();

    public GwiseTaskBean(ObservableListWrapperA<Notification> notifications) {
        this.notifications = notifications;
    }

    public GwiseTaskBean(List<Notification> notifications, GwiseTask task) {
        super(task);
        this.notifications = notifications;
    }

    @JsonIgnore
    public abstract TaskType getType();

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
