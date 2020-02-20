package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.PruningTask;
import com.etlsolutions.javafx.data.log.task.PruningTaskValueWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author zc
 */
public class PruningTaskDataModel extends TaskDetailDataModel<PruningTaskValueWrapper> {

    public PruningTaskDataModel(PruningTaskValueWrapper wrapper) {
        super(wrapper);
    }    
    
    public PruningTaskDataModel(PruningTask task) {
        super(new PruningTaskValueWrapper(task));
    }

    public ValueWrapper<String> getOverallRemoved() {
        return detail.getOverallRemovedValueWrapper();
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
