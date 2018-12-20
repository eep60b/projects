package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class PruningTaskDetailValueWrapper extends TaskDetailValueWrapper {

    private final ValueWrapper<String> orverallRemoved;
    private final ValueWrapper<String> eachBranchRemoved;

    public PruningTaskDetailValueWrapper() {
        this.orverallRemoved = new ValueWrapper<>("0");
        this.eachBranchRemoved = new ValueWrapper<>("0");
    }

    public PruningTaskDetailValueWrapper(PruningTask task) {
        super(task);
        this.orverallRemoved = new ValueWrapper<>(String.valueOf(task.getOverallRemoved()));
        this.eachBranchRemoved = new ValueWrapper<>(String.valueOf(task.getEachBranchRemoved()));
    }

    public ValueWrapper<String> getOrverallRemovedValueWrapper() {
        return orverallRemoved;
    }

    public double getOrverallRemoved() {
        return Double.parseDouble(orverallRemoved.getValue());
    }
    
    public ValueWrapper<String> getEachBranchRemovedValueWrapper() {
        return eachBranchRemoved;
    }
       
    public double getEachBranchRemoved() {
        return Double.parseDouble(eachBranchRemoved.getValue());
    }
    
    @Override
    public TaskType getType() {
        return TaskType.PRUNING;
    }

}
