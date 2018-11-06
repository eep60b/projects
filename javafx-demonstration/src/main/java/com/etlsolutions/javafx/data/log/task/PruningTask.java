package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class PruningTask extends Task {

    private double overallRemoved;
    private double eachBranchRemoved;
    
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
