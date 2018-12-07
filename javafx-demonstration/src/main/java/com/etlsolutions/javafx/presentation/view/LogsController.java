package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
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

        ValueWrapper<ProjectContents> projectContentsValueWrapper = ProjectManager.getInstance().getContentsValueWrapper();
        LogProjectPropertyChangeAdapter logProjectPropertyChangeAdapter = new LogProjectPropertyChangeAdapter(logsTreeView);
        logProjectPropertyChangeAdapter.process(projectContentsValueWrapper.getValue());
        projectContentsValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, logProjectPropertyChangeAdapter);

    }
}
