package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.gwise.AbstractFXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class ViewTabsController extends AbstractFXMLController {

    @FXML
    private TabPane viewTabsTabPane;

    @Override
    public void initializeComponents() {
      
        viewTabsTabPane.getSelectionModel().selectedItemProperty().addListener(new ViewTabChangeAdapter());
    }
}
