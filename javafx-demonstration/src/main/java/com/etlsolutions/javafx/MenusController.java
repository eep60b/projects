package com.etlsolutions.javafx;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.AddAreaDataModel;
import com.etlsolutions.javafx.presentation.menu.add.growingmedium.AddGrowingMediumDataModel;
import com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel;
import com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDataModel;
import com.etlsolutions.javafx.presentation.menu.file.NewProjectDialogEventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class MenusController extends AbstractFXMLController {

    //The file menu
    @FXML
    private MenuItem newProjectMenuItem;

    //The save menu
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

    @Override
    public void initializeComponents() {

        newProjectMenuItem.setOnAction(new NewProjectDialogEventHandler());

        addPlantsMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddPlantsDataModel()));
        addPlantTypeMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddPlantTypeDataModel()));
        addAreaMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddAreaDataModel()));
        
        
        addGrowingMediumMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddGrowingMediumDataModel()));        
    }
}
