package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantsQuantity.Type;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Spinner;

/**
 *
 * @author zc
 */
public class QuantityTypePropertyChangeAdapter implements PropertyChangeListener {

    private final AbstractPlantDataModel model;
    private final Spinner<Integer> plantNumberSpinner;

    public QuantityTypePropertyChangeAdapter(AbstractPlantDataModel model, Spinner<Integer> plantNumberSpinner) {
        this.model = model;
        this.plantNumberSpinner = plantNumberSpinner;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ValueWrapper<Type> wrapper = (ValueWrapper<Type>) evt.getSource();
        plantNumberSpinner.getValueFactory().setValue(model.getQuantityValueWrapper().getValue());
        Type type = wrapper.getValue();
        plantNumberSpinner.setVisible(type == Type.MULTIPLE || type == Type.ESTIMATION);
    }
}
