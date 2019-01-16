package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class TransplantTask extends Task {

    private int fromLocationId;
    private int toLocationId;

    public TransplantTask() {
    }

    public TransplantTask(DataUnitValueWrapper valueWrapper, TransplantTasklValueWrapper detailValueWrapper) {
        
        super(valueWrapper, detailValueWrapper);
        fromLocationId = detailValueWrapper.getFromLocationValueWrapper().getValue().getId();
        fromLocationId = detailValueWrapper.getToLocationValueWrapper().getValue().getId();        
    }

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
