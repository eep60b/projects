package com.etlsolutions.javafx.presentation.menu.add.planttype;

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
        
        AddPlantTypeDataModel model = (AddPlantTypeDataModel) evt.getSource();        
        varityListView.setItems(model.getVarieties());
    } 
}
