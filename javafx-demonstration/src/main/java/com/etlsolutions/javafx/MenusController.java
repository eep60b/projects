package com.etlsolutions.javafx;

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
    
    @FXML    
    private MenuItem newProjectMenuItem;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newProjectMenuItem.setOnAction(new NewProjectDialogEventHandler());
    }    
    
}
