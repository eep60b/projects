package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author zc
 */
public class PlantGroupPropertyChangeAdapter implements PropertyChangeListener {

    private final AddPlantsDataModel model;

    public PlantGroupPropertyChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ValueWrapper<PlantGroup> groupValueWrapper = (ValueWrapper<PlantGroup>) evt.getSource();
        model.getPlantTypes().clear();
        model.getPlantTypes().addAll(groupValueWrapper.getValue().getPlantsSubGroups());        
    } 
}
