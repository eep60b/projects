package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.presentation.ComponentsFXMLControllerNodeWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author zc
 */
public class SelectedTaskTypePropertyAdapter implements PropertyChangeListener {

    public SelectedTaskTypePropertyAdapter(TabPane mainTabPane, Tab detailTab, Map<TaskType, ComponentsFXMLControllerNodeWrapper<TaskDetailDataModel>> map) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
