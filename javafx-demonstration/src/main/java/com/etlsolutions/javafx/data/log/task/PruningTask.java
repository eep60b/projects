package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.log.Log;

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
