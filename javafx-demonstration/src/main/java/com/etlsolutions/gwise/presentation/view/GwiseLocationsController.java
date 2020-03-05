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
 * FXML Controller class for the location view.
 *
 * @author zc
 */
public class GwiseLocationsController extends AbstractFXMLController {

    @FXML
    private TreeView<GwiseDataUnit> locationsTreeView;

    @Override
    public void initializeComponents() {

        locationsTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        ValueWrapper<GwiseProjectContents> projectContentsValueWrapper = ProjectManager.getInstance().getGwiseProjectContentsWrapper();
        GwiseLocationProjectPropertyChangeAdapter locationProjectPropertyChangeAdapter = new GwiseLocationProjectPropertyChangeAdapter(locationsTreeView);
        locationProjectPropertyChangeAdapter.process(projectContentsValueWrapper.getValue());
        projectContentsValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, locationProjectPropertyChangeAdapter);

        locationsTreeView.getSelectionModel().selectedItemProperty().addListener(new GwiseSelectedItemChangeAdapter());
    }
}
