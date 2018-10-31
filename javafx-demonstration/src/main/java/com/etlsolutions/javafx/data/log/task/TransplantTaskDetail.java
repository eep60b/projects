package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class TransplantTaskDetail implements TaskDetail {
     
  public int fromLocationId;
  public int toLocationId;

    public int getFromLocationId() {
        return fromLocationId;
    }

    public void setFromLocationId(int fromLocationId) {
        this.fromLocationId = fromLocationId;
    }

    public int getToLocationId() {
        return toLocationId;
    }

    public void setToLocationId(int toLocationId) {
        this.toLocationId = toLocationId;
    }

    @Override
    public TaskType getType() {
        return TaskType.TRANSPLANTING;
    }
}
