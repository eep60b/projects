package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.gwise.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.system.ProjectContents;
import com.etlsolutions.gwise.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeView;

/**
 * The LogsController class is a FXML Controller class to control the view tab
 * of logs.
 *
 * @author zc
 */
public class LogsController extends AbstractFXMLController {

    @FXML
    private TreeView<DataUnit> logsTreeView;

    @Override
    public void initializeComponents() {

        logsTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                  
        ValueWrapper<ProjectContents> projectContentsValueWrapper = ProjectManager.getInstance().getContentsValueWrapper();
        LogProjectPropertyChangeAdapter logProjectPropertyChangeAdapter = new LogProjectPropertyChangeAdapter(logsTreeView);
        logProjectPropertyChangeAdapter.process(projectContentsValueWrapper.getValue());

        projectContentsValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, logProjectPropertyChangeAdapter);
        
        //This listener is added so when the selection is changed in the tree view, the editon can change accordingly.
        logsTreeView.getSelectionModel().selectedItemProperty().addListener(new SelectedItemChangeAdapter());
    }
}
