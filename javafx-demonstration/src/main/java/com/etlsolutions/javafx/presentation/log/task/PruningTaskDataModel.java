package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.log.task.PruningTask;
import com.etlsolutions.javafx.data.log.task.PruningTaskDetail;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author zc
 */
public class PruningTaskDataModel extends TaskDetailDataModel<PruningTaskDetail> {

    public PruningTaskDataModel() {
        super(LogFactory.getInstance().getDefaultPruningTaskDetail());
    }    
    
    public PruningTaskDataModel(PruningTask task) {
        super(new PruningTaskDetail(task.getOverallRemoved(), task.getEachBranchRemoved()));
    }

    public ValueWrapper<String> getOverallRemoved() {
        return detail.getOrverallRemoved();
    }

    public ValueWrapper<String> getEachBranchRemoved() {
        return detail.getEachBranchRemoved();
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
