package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.gwise.AbstractFXMLController;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.menu.file.CloseProjectEventHnadler;
import com.etlsolutions.javafx.presentation.menu.file.DeleteProjectEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.ExitApplicationEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.NewProjectDataModel;
import com.etlsolutions.javafx.presentation.menu.file.NewProjectDialogEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.OpenProjectDataModel;
import com.etlsolutions.javafx.presentation.menu.file.OpenProjectEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.SaveAsProjectEventHandler;
import com.etlsolutions.javafx.presentation.menu.file.SaveProjectEventHandler;
import com.etlsolutions.gwise.system.ProjectContents;
import com.etlsolutions.gwise.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

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
    private MenuItem deleteProjectMenuItem;

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

    //Edit menus
    @FXML
    private MenuItem deleteMenuItem;

    //Toobar items:
    @FXML
    private Button newProjectToolbarButton;

    @FXML
    private Button openProjectToolbarButton;

    @FXML
    private Button saveProjectToolbarButton;

    @FXML
    private Button deleteToolbarButton;

    @FXML
    private Button cutToolbarButton;

    @FXML
    private Button copyToolbarButton;

    @FXML
    private Button pasteToolbarButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchToolbarButton;

    @Override
    public void initializeComponents() {

        ValueWrapper<ProjectContents> valueWrapper = ProjectManager.getInstance().getContentsValueWrapper();

        newProjectMenuItem.setOnAction(new NewProjectDialogEventHandler(new NewProjectDataModel()));
        openProjectMenuItem.setOnAction(new OpenProjectEventHandler(new OpenProjectDataModel()));

        saveProjectMenuItem.setOnAction(new SaveProjectEventHandler());

        saveAsProjectMenuItem.setOnAction(new SaveAsProjectEventHandler());
        closeProjectMenuItem.setOnAction(new CloseProjectEventHnadler());
        deleteMenuItem.setOnAction(new DeleteProjectEventHandler());
        exitMenuItem.setOnAction(new ExitApplicationEventHandler());

        newProjectToolbarButton.setOnAction(new NewProjectDialogEventHandler(new NewProjectDataModel()));
        openProjectToolbarButton.setOnAction(new OpenProjectEventHandler(new OpenProjectDataModel()));
        saveProjectToolbarButton.setOnAction(new SaveProjectEventHandler());

        addPlantsMenuItem.setOnAction(new AddPlantsEventHandler());
        addPlantSubGroupMenuItem.setOnAction(new AddPlantSubGroupEventHandler());
        addAreaMenuItem.setOnAction(new AddAreaEventHandler());
        addGrowingMediumMenuItem.setOnAction(new AddGrowingMediumEventHandler());
        addGventMenuItem.setOnAction(new AddGventEventHandler());

        valueWrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new MenuItemPropertyChangeAdapter(valueWrapper,
                saveProjectMenuItem, saveAsProjectMenuItem, closeProjectMenuItem, addPlantsMenuItem, addPlantSubGroupMenuItem, addAreaMenuItem,
                addGrowingMediumMenuItem, addGventMenuItem));
    }
}
