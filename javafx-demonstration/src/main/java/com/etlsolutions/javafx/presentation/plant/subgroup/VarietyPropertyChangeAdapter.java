package com.etlsolutions.javafx.presentation.plant.subgroup;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class VarietyPropertyChangeAdapter implements PropertyChangeListener {

    private final ListView varityListView;

    public VarietyPropertyChangeAdapter(ListView varityListView) {
        this.varityListView = varityListView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AbstractPlantSubGroupDataModel model = (AbstractPlantSubGroupDataModel) evt.getSource();        
        varityListView.setItems(model.getVarieties());
    } 
}
