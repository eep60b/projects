package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Location;

/**
 *
 * @author zc
 */
public class TransplantTaskDetail implements TaskDetail {
     
  public final ValueWrapper<Location> fromLocation;
  public final ValueWrapper<Location> toLocation;

    public TransplantTaskDetail(Location fromLocation, Location toLocation) {
        this.fromLocation = new ValueWrapper(fromLocation);
        this.toLocation =  new ValueWrapper(toLocation);
    }

    public ValueWrapper<Location> getFromLocation() {
        return fromLocation;
    }

    public ValueWrapper<Location> getToLocation() {
        return toLocation;
    }

    @Override
    public TaskType getType() {
        return TaskType.TRANSPLANTING;
    }
}
