package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.area.AddAreaDataModel;
import com.etlsolutions.javafx.presentation.area.EditAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.AddSubAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.EditSubAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.location.AddLocationDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.location.EditLocationDataModel;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class TransplantTaskFXMLController extends AbstractComponentsFXMLController<TransplantTaskDataModel> {

    @FXML
    private ComboBox<Area> fromAreaComboBox;

    @FXML
    private ComboBox<SubArea> fromSubAreaComboBox;

    @FXML
    private ComboBox<Location> fromLocationComboBox;

    @FXML
    private ComboBox<Area> toAreaComboBox;

    @FXML
    private ComboBox<SubArea> toSubAreaComboBox;

    @FXML
    private ComboBox<Location> toLocationComboBox;

    @FXML
    private Button addFromAreaButton;

    @FXML
    private Button editFromAreaButton;

    @FXML
    private Button addFromSubAreaButton;

    @FXML
    private Button editFromSubAreaButton;
    
    @FXML
    private Button addFromLocationButton;

    @FXML
    private Button editFromLocationButton;

    @FXML
    private Button addToAreaButton;

    @FXML
    private Button editToAreaButton;

    @FXML
    private Button addToSubAreaButton;

    @FXML
    private Button editToSubAreaButton;
    
    @FXML
    private Button addToLocationButton;

    @FXML
    private Button editToLocationButton;
    
    @Override
    public void initializeComponents() {

        fromAreaComboBox.setItems(model.getFromAreas());
        fromAreaComboBox.getSelectionModel().select(model.getSelectedFromArea().getValue());
        fromAreaComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getSelectedFromArea()));

        fromSubAreaComboBox.setItems(model.getFromSubAreas());
        fromSubAreaComboBox.getSelectionModel().select(model.getSelectedFromSubArea().getValue());
        fromSubAreaComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getSelectedFromSubArea()));

        fromLocationComboBox.setItems(model.getFromLocations());
        fromLocationComboBox.getSelectionModel().select(model.getFromLocation().getValue());
        fromLocationComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getFromLocation()));
        
        toAreaComboBox.setItems(model.getToAreas());
        toAreaComboBox.getSelectionModel().select(model.getSelectedToArea().getValue());
        toAreaComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getSelectedToArea()));

        toSubAreaComboBox.setItems(model.getToSubAreas());
        toSubAreaComboBox.getSelectionModel().select(model.getSelectedToSubArea().getValue());
        toSubAreaComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getSelectedToSubArea()));

        toLocationComboBox.setItems(model.getToLocations());
        toLocationComboBox.getSelectionModel().select(model.getToLocation().getValue());
        toLocationComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getToLocation())); 
                
        addFromAreaButton.setOnAction(new AddItemEventHandler<>(model.getFromAreas(), model.getSelectedFromArea(), new AddAreaDataModel()));
        editFromAreaButton.setOnAction(new EditItemEventHandler<>(new EditAreaDataModel(model.getSelectedFromArea().getValue())));
        
        addFromSubAreaButton.setOnAction(new AddItemEventHandler<>(model.getFromSubAreas(), model.getSelectedFromSubArea(), new AddSubAreaDataModel(model.getSelectedFromArea().getValue())));
        editFromSubAreaButton.setOnAction(new EditItemEventHandler<>(new EditSubAreaDataModel(model.getSelectedFromArea().getValue(), model.getSelectedFromSubArea().getValue())));
  
        addFromLocationButton.setOnAction(new AddItemEventHandler<>(model.getFromLocations(), model.getFromLocation(), new AddLocationDataModel()));
        editFromLocationButton.setOnAction(new EditItemEventHandler<>(new EditLocationDataModel(model.getSelectedFromArea().getValue(), model.getSelectedFromSubArea().getValue(), model.getFromLocation().getValue())));
        
        addToAreaButton.setOnAction(new AddItemEventHandler<>(model.getToAreas(), model.getSelectedToArea(), new AddAreaDataModel()));
        editToAreaButton.setOnAction(new EditItemEventHandler<>(new EditAreaDataModel(model.getSelectedToArea().getValue())));
        
        addToSubAreaButton.setOnAction(new AddItemEventHandler<>(model.getToSubAreas(), model.getSelectedToSubArea(), new AddSubAreaDataModel(model.getSelectedToArea().getValue())));
        editToSubAreaButton.setOnAction(new EditItemEventHandler<>(new EditSubAreaDataModel(model.getSelectedToArea().getValue(), model.getSelectedToSubArea().getValue())));
  
        addToLocationButton.setOnAction(new AddItemEventHandler<>(model.getToLocations(), model.getToLocation(), new AddLocationDataModel()));
        editToLocationButton.setOnAction(new EditItemEventHandler<>(new EditLocationDataModel(model.getSelectedToArea().getValue(), model.getSelectedToSubArea().getValue(), model.getToLocation().getValue())));
        
        model.getFromAreas().addListener(new ListChangeAdapter<>(model.getFromAreas(), fromAreaComboBox));
        model.getSelectedFromArea().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new TransplantTaskFromAreaPropertyChangeAdapter(model, fromAreaComboBox));
        model.getFromSubAreas().addListener(new ListChangeAdapter<>(model.getFromSubAreas(), fromSubAreaComboBox));
        model.getSelectedFromSubArea().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new TransplantTaskFromSubAreaPropertyChangeAdapter(model, fromSubAreaComboBox));
        model.getFromLocations().addListener(new ListChangeAdapter<>(model.getFromLocations(), fromLocationComboBox));
        model.getFromLocation().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new TransplantTaskFromLocationPropertyChangeAdapter(model, fromLocationComboBox));

        model.getToAreas().addListener(new ListChangeAdapter<>(model.getToAreas(), fromAreaComboBox));
        model.getSelectedToArea().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new TransplantTaskToAreaPropertyChangeAdapter(model, fromAreaComboBox));
        model.getToSubAreas().addListener(new ListChangeAdapter<>(model.getToSubAreas(), fromSubAreaComboBox));
        model.getSelectedToSubArea().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new TransplantTaskToSubAreaPropertyChangeAdapter(model, fromSubAreaComboBox));
        model.getToLocations().addListener(new ListChangeAdapter<>(model.getToLocations(), fromLocationComboBox));
        model.getToLocation().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new TransplantTaskToLocationPropertyChangeAdapter(model, fromLocationComboBox));
    }
}
