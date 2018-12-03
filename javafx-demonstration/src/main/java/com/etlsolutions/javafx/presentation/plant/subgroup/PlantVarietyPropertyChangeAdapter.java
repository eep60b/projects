package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.plant.plantvariety.EditVarietyDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author Zhipeng
 */
public class PlantVarietyPropertyChangeAdapter implements PropertyChangeListener {

    private final Button editPlantVarietyButton;
    private final Button removePlantVarietyButton;
    private final ListView<PlantVariety> plantVarityListView;

    public PlantVarietyPropertyChangeAdapter(Button editPlantVarietyButton, Button removePlantVarietyButton, ListView<PlantVariety> plantVarityListView) {
        this.editPlantVarietyButton = editPlantVarietyButton;
        this.removePlantVarietyButton = removePlantVarietyButton;
        this.plantVarityListView = plantVarityListView;
    }

    
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process((ValueWrapper<PlantVariety>) evt.getSource());
    }

    public void process(ValueWrapper<PlantVariety> wrapper) {
        boolean hasVariety = wrapper.getValue() != null;
        editPlantVarietyButton.setDisable(!hasVariety);
        removePlantVarietyButton.setDisable(!hasVariety);
        if (hasVariety) {
        EditVarietyDataModel vm = new EditVarietyDataModel(wrapper.getValue());
        vm.addPropertyChangeListener( EditVarietyDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(plantVarityListView));        
        editPlantVarietyButton.setOnAction(new EditItemEventHandler(vm));
        }
    }
    
}
