package com.etlsolutions.javafx;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel;
import com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel;
import com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel;
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
    
    @FXML
    private MenuItem addPlantTypeMenuItem;
    
    @FXML
    private MenuItem addAreaMenuItem;
    
    @FXML
    private MenuItem addEventMenuItem;
    
    @FXML
    private MenuItem addIssueMenuItem;
    
    @FXML
    private MenuItem addNoteMenuItem;
    
    @FXML
    private MenuItem addReferenceMenuItem;
    
    @FXML
    private MenuItem addTaskMenuItem;
    
    @FXML
    private MenuItem addWeatherRecordMenuItem;
            
    @FXML
    private MenuItem addGrowingMediumMenuItem;
    
    @FXML
    private MenuItem addFertiliserMenuItem;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        newProjectMenuItem.setOnAction(new NewProjectDialogEventHandler());

        addPlantsMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddPlantsDataModel()));
        addPlantTypeMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddPlantTypeDialogDataModel()));
        addAreaMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddAreaDialogDataModel()));
    }

}
