package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.plant.PlantsQuantity.Type;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Spinner;

/**
 *
 * @author zc
 */
public class QuantityTypePropertyChangeAdapter implements PropertyChangeListener {

    private final Spinner<Integer> plantNumberSpinner;

    public QuantityTypePropertyChangeAdapter(Spinner<Integer> plantNumberSpinner) {
        
        this.plantNumberSpinner = plantNumberSpinner;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddPlantDataModel model = (AddPlantDataModel) evt.getSource();
        plantNumberSpinner.getValueFactory().setValue(model.getQuantityValueWrapper().getValue());
        Type type = model.getQuantityTypeValueWrapper().getValue();
        plantNumberSpinner.setDisable(type == Type.SINGLE || type == Type.NO_COUNTING);
    }
}
