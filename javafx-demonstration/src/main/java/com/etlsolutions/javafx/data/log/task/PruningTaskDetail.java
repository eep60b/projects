package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class PruningTaskDetail implements TaskDetail {

    private final ValueWrapper<Integer> overAllPercentageTaken;

    public PruningTaskDetail(ValueWrapper<Integer> overAllPercentageTaken) {
        this.overAllPercentageTaken = overAllPercentageTaken;
    }

    public ValueWrapper<Integer> getOverAllPercentageTaken() {
        return overAllPercentageTaken;
    }
    
    @Override
    public TaskType getType() {
        return TaskType.PRUNING;
    }
    
}
