package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.task.CustomTaskDetailValueWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author Zhipeng
 */
public class CustomTaskDetailDataModel extends TaskDetailDataModel {

    public CustomTaskDetailDataModel(CustomTaskDetailValueWrapper detail) {
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
