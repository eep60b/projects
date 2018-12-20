package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.log.task.PruningTask;
import com.etlsolutions.javafx.data.log.task.PruningTaskDetailValueWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author zc
 */
public class PruningTaskDataModel extends TaskDetailDataModel<PruningTaskDetailValueWrapper> {

    public PruningTaskDataModel() {
        super(LogFactory.getInstance().getDefaultPruningTaskDetail());
    }    
    
    public PruningTaskDataModel(PruningTask task) {
        super(new PruningTaskDetailValueWrapper(task));
    }

    public ValueWrapper<String> getOverallRemoved() {
        return detail.getOrverallRemovedValueWrapper();
    }

    public ValueWrapper<String> getEachBranchRemoved() {
        return detail.getEachBranchRemovedValueWrapper();
    }
      
    @Override
    public String getFxmlPath() {
        return "/fxml/log/PruningFXML.fxml";
    }

    @Override
    public void save() {
        
    }

    @Override
    public void remove(RemoveEventId id) {
        
    }
    
}
