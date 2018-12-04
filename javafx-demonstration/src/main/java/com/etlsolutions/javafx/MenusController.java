package com.etlsolutions.javafx;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.AddAreaDataModel;
import com.etlsolutions.javafx.presentation.growingmedium.AddGrowingMediumDataModel;
import com.etlsolutions.javafx.presentation.log.gvent.AddGventDataModel;
import com.etlsolutions.javafx.presentation.plant.AddPlantDataModel;
import com.etlsolutions.javafx.presentation.menu.file.CloseProjectEventHnadler;
import com.etlsolutions.javafx.presentation.menu.file.ExitApplicationEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.NewProjectDialogEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.OpenProjectEventHnadler;
import com.etlsolutions.javafx.presentation.menu.file.SaveAsProjectEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.SaveProjectEventHandler;
import com.etlsolutions.javafx.presentation.plant.subgroup.CreateRootedPlantSubGroupDataModel;
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
    
    @FXML
    private MenuItem openProjectMenuItem;
    
    @FXML
    private MenuItem closeProjectMenuItem;
    
    @FXML
    private MenuItem saveProjectMenuItem;
    
    @FXML
    private MenuItem saveAsProjectMenuItem;
    
    @FXML
    private MenuItem printMenuItem;
    
    @FXML
    private MenuItem exitMenuItem;

    //The save menu
    @FXML
    private MenuItem addPlantsMenuItem;
    
    @FXML
    private MenuItem addPlantSubGroupMenuItem;
    
    @FXML
    private MenuItem addAreaMenuItem;
    
    @FXML
    private MenuItem addGventMenuItem;
    
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

    //Edit menu
    @FXML
    private MenuItem deleteMenuItem;
    
    @Override
    public void initializeComponents() {
        
        newProjectMenuItem.setOnAction(new NewProjectDialogEventHandler());
        openProjectMenuItem.setOnAction(new OpenProjectEventHnadler());
        saveProjectMenuItem.setOnAction(new SaveProjectEventHandler());
        saveAsProjectMenuItem.setOnAction(new SaveAsProjectEventHandler());
        closeProjectMenuItem.setOnAction(new CloseProjectEventHnadler());
        exitMenuItem.setOnAction(new ExitApplicationEventHandler());
        
        addPlantsMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddPlantDataModel()));
        addPlantSubGroupMenuItem.setOnAction(new FXMLActionEventHandler<>(new CreateRootedPlantSubGroupDataModel()));
        addAreaMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddAreaDataModel()));
        
        addGrowingMediumMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddGrowingMediumDataModel()));        
        addGventMenuItem.setOnAction(new FXMLActionEventHandler<>(new AddGventDataModel()));
    }
}
