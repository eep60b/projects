package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class PruningTask extends Task {

    private double overallRemoved;
    private double eachBranchRemoved;

    public PruningTask() {
    }

    public PruningTask(DataUnitValueWrapper valueWrapper, PruningTaskValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper);
        overallRemoved = detailValueWrapper.getOverallRemoved();
        eachBranchRemoved = detailValueWrapper.getEachBranchRemoved();
    }
    
    @Override
    public TaskType getType() {
        return TaskType.PRUNING;
    }

    public double getOverallRemoved() {
        return overallRemoved;
    }

    public void setOverallRemoved(double overallRemoved) {
        this.overallRemoved = overallRemoved;
    }

    public double getEachBranchRemoved() {
        return eachBranchRemoved;
    }

    public void setEachBranchRemoved(double eachBranchRemoved) {
        this.eachBranchRemoved = eachBranchRemoved;
    }  
}
