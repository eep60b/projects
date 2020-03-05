package com.etlsolutions.gwise.presentation.view;

import com.etlsolutions.gwise.AbstractFXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

/**
 * GwiseViewTabsController is a FXML Controller class which control all the view tabs.
 *
 * @author zc
 */
public class GwiseViewTabsController extends AbstractFXMLController {

    @FXML
    private TabPane viewTabsTabPane;

    @Override
    public void initializeComponents() {
      
        viewTabsTabPane.getSelectionModel().selectedItemProperty().addListener(new GwiseViewTabChangeAdapter());
    }
}
