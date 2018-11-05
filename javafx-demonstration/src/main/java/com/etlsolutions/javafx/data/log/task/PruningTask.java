package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class PruningTask extends Task {

    private double overAllPercentageTaken;
    
    @Override
    public TaskType getType() {
        return TaskType.PRUNING;
    }

    public double getOverAllPercentageTaken() {
        return overAllPercentageTaken;
    }

    public void setOverAllPercentageTaken(double overAllPercentageTaken) {
        this.overAllPercentageTaken = overAllPercentageTaken;
    }
  
    
}
