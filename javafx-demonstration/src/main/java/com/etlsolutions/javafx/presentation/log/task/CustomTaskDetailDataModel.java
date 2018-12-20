/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(RemoveEventId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
