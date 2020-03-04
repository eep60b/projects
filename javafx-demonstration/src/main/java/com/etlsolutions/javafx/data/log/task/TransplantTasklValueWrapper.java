package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.gwise.system.ProjectManager;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class TransplantTasklValueWrapper extends TaskValueWrapper {

    private final ValueWrapper<Location> fromLocationValueWrapper;
    private final ValueWrapper<Location> toLocationValueWrapper;

    public TransplantTasklValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications, Location fromLocation, Location toLocation) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, notifications);
        fromLocationValueWrapper = new ValueWrapper(fromLocation);
        toLocationValueWrapper = new ValueWrapper(toLocation);
    }

    public TransplantTasklValueWrapper(TransplantTask task) {
        super(task);
        ProjectManager m = ProjectManager.getInstance();
        fromLocationValueWrapper = new ValueWrapper(m.getItem(task.getFromLocationId()));
        toLocationValueWrapper = new ValueWrapper(m.getItem(task.getToLocationId()));
    }

    public ValueWrapper<Location> getFromLocationValueWrapper() {
        return fromLocationValueWrapper;
    }

    public ValueWrapper<Location> getToLocationValueWrapper() {
        return toLocationValueWrapper;
    }

    @Override
    public TaskType getType() {
        return TaskType.TRANSPLANTING;
    }
}
