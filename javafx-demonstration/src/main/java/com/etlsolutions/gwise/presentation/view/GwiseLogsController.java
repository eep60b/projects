package com.etlsolutions.gwise.presentation.view;

import com.etlsolutions.gwise.AbstractFXMLController;
import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.system.GwiseProjectContents;
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
public class GwiseLogsController extends AbstractFXMLController {

    @FXML
    private TreeView<GwiseDataUnit> logsTreeView;

    @Override
    public void initializeComponents() {

        logsTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                  
        ValueWrapper<GwiseProjectContents> projectContentsValueWrapper = ProjectManager.getInstance().getGwiseProjectContentsWrapper();
        GwiseLogProjectPropertyChangeAdapter logProjectPropertyChangeAdapter = new GwiseLogProjectPropertyChangeAdapter(logsTreeView);
        logProjectPropertyChangeAdapter.process(projectContentsValueWrapper.getValue());

        projectContentsValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, logProjectPropertyChangeAdapter);
        
        //This listener is added so when the selection is changed in the tree view, the editon can change accordingly.
        logsTreeView.getSelectionModel().selectedItemProperty().addListener(new GwiseSelectedItemChangeAdapter());
    }
}
