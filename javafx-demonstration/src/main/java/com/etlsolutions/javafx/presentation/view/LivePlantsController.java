package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;

/**
 * The LivePlantsController class is an FXML Controller class which controls the plants tree view.
 *
 * @author zc
 */
public class LivePlantsController extends AbstractFXMLController {

    @FXML
    private TreeView<DataUnit> livePlantsTreeView;

    @Override
    public void initializeComponents() {

        ValueWrapper<ProjectContents> projectContentsValueWrapper = ProjectManager.getInstance().getContentsValueWrapper();        
        LivePlantProjectPropertyChangeAdapter livePlantProjectPropertyChangeAdapter = new LivePlantProjectPropertyChangeAdapter(livePlantsTreeView);
        livePlantProjectPropertyChangeAdapter.process(projectContentsValueWrapper.getValue());
        projectContentsValueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, livePlantProjectPropertyChangeAdapter);
        
        ViewTabsManager.getInstance().getTreeViewMap().put("plantsViewTab", livePlantsTreeView);
    }
}
