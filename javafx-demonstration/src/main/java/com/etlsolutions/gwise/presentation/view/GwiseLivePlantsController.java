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
 * The LivePlantsController class is an FXML Controller class which controls the
 * plants tree view.
 *
 * @author zc
 */
public class GwiseLivePlantsController extends AbstractFXMLController {

    @FXML
    private TreeView<GwiseDataUnit> livePlantsTreeView;

    @Override
    public void initializeComponents() {

        livePlantsTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        ValueWrapper<GwiseProjectContents> projectContentsValueWrapper = ProjectManager.getInstance().getGwiseProjectContentsWrapper();
        GwiseLivePlantProjectPropertyChangeAdapter livePlantProjectPropertyChangeAdapter = new GwiseLivePlantProjectPropertyChangeAdapter(livePlantsTreeView);
        livePlantProjectPropertyChangeAdapter.process(projectContentsValueWrapper.getValue());
        projectContentsValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, livePlantProjectPropertyChangeAdapter);

        livePlantsTreeView.getSelectionModel().selectedItemProperty().addListener(new GwiseSelectedItemChangeAdapter());
    }
}
