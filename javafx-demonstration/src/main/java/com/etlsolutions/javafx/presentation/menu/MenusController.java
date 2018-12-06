package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.menu.file.CloseProjectEventHnadler;
import com.etlsolutions.javafx.presentation.menu.file.ExitApplicationEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.NewProjectDialogEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.OpenProjectEventHnadler;
import com.etlsolutions.javafx.presentation.menu.file.SaveAsProjectEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.SaveProjectEventHandler;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
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

        ValueWrapper<ProjectContents> valueWrapper = ProjectManager.getInstance().getContentsValueWrapper();

        newProjectMenuItem.setOnAction(new NewProjectDialogEventHandler());
        openProjectMenuItem.setOnAction(new OpenProjectEventHnadler());

        saveProjectMenuItem.setOnAction(new SaveProjectEventHandler());

        saveAsProjectMenuItem.setOnAction(new SaveAsProjectEventHandler());
        closeProjectMenuItem.setOnAction(new CloseProjectEventHnadler());
        exitMenuItem.setOnAction(new ExitApplicationEventHandler());

        valueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new MenuItemPropertyChangeAdapter(valueWrapper, saveProjectMenuItem, saveAsProjectMenuItem, closeProjectMenuItem));
        valueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AddPlantsPropertyChangeAdapter(addPlantsMenuItem, valueWrapper));
        valueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AddPlantSubGroupPropertyChangeAdapter(addPlantSubGroupMenuItem, valueWrapper));
        valueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AddAreaPropertyChangeAdapter(addAreaMenuItem, valueWrapper));
        valueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AddGrowingMediumPropertyChangeAdapter(addGrowingMediumMenuItem, valueWrapper));
        valueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AddGventPropertyChangeAdapter(addGventMenuItem, valueWrapper));

        
    }
}
