package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class PruningTaskDetail implements TaskDetail {

    private final ValueWrapper<String> orverallRemoved;
    private final ValueWrapper<String> eachBranchRemoved;

    public PruningTaskDetail(double orverallRemoved, double eachBranchRemoved) {
        this.orverallRemoved = new ValueWrapper<>(String.valueOf(orverallRemoved));
        this.eachBranchRemoved = new ValueWrapper<>(String.valueOf(eachBranchRemoved));
    }

    public ValueWrapper<String> getOrverallRemoved() {
        return orverallRemoved;
    }

    public ValueWrapper<String> getEachBranchRemoved() {
        return eachBranchRemoved;
    }
    
    @Override
    public TaskType getType() {
        return TaskType.PRUNING;
    }

}
