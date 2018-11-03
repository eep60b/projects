package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class PruningTask extends Task {

    @Override
    public TaskType getType() {
        return TaskType.PRUNING;
    }
  
}
