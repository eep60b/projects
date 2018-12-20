package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class TransplantTaskDetailValueWrapper extends TaskDetailValueWrapper {

    private final ValueWrapper<Location> fromLocationValueWrapper;
    private final ValueWrapper<Location> toLocationValueWrapper;

    public TransplantTaskDetailValueWrapper() {
        fromLocationValueWrapper = new ValueWrapper(null);
        toLocationValueWrapper = new ValueWrapper(null);
    }

    public TransplantTaskDetailValueWrapper(TransplantTask task) {
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
