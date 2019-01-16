package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author zc
 */
public class PlantGroupPropertyChangeAdapter implements PropertyChangeListener {

    private final AddPlantDataModel model;

    public PlantGroupPropertyChangeAdapter(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ValueWrapper<PlantGroup> groupValueWrapper = (ValueWrapper<PlantGroup>) evt.getSource();
        model.getPlantSubGroups().clear();
        model.getPlantSubGroups().addAll(groupValueWrapper.getValue().getPlantSubGroups());        
    } 
}
