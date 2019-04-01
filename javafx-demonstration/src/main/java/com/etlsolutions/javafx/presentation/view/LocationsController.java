package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class for the location view.
 *
 * @author zc
 */
public class LocationsController extends AbstractFXMLController {

    @FXML
    private TreeView<DataUnit> locationsTreeView;

    @Override
    public void initializeComponents() {

        locationsTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        ValueWrapper<ProjectContents> projectContentsValueWrapper = ProjectManager.getInstance().getContentsValueWrapper();
        LocationProjectPropertyChangeAdapter locationProjectPropertyChangeAdapter = new LocationProjectPropertyChangeAdapter(locationsTreeView);
        locationProjectPropertyChangeAdapter.process(projectContentsValueWrapper.getValue());
        projectContentsValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, locationProjectPropertyChangeAdapter);

        locationsTreeView.getSelectionModel().selectedItemProperty().addListener(new SelectedItemChangeAdapter());
    }
}