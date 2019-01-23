package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.AbstractFXMLController;
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

    @FXML
    private Tab plantsViewTab;

    @FXML
    private Tab locationsViewTab;

    @FXML
    private Tab diaryViewTab;

    @Override
    public void initializeComponents() {

        viewTabsTabPane.getSelectionModel().selectedItemProperty().addListener(new ViewTabChangeAdapter());
    }
}
