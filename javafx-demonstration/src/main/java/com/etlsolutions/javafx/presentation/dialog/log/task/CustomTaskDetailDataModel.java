package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.javafx.data.log.task.CustomTaskValueWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author Zhipeng
 */
public class CustomTaskDetailDataModel extends TaskDetailDataModel {

    public CustomTaskDetailDataModel(CustomTaskValueWrapper detail) {
        super(detail);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/CustomTaskFXML.fxml";
    }

    @Override
    public void save() {        
    }

    @Override
    public void remove(RemoveEventId id) {      
    }

}
