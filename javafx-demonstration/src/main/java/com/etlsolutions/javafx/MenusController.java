package com.etlsolutions.javafx;

import com.etlsolutions.javafx.presentation.AbstractActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel;
import com.etlsolutions.javafx.presentation.menu.file.NewProjectDialogEventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class MenusController implements Initializable {

    //The file menu
    @FXML
    private MenuItem newProjectMenuItem;

    //The add menu
    @FXML
    private MenuItem addPlantsMenuItem;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        newProjectMenuItem.setOnAction(new NewProjectDialogEventHandler());

        addPlantsMenuItem.setOnAction(new AbstractActionEventHandler<>(new AddPlantsDataModel()));
    }

}
