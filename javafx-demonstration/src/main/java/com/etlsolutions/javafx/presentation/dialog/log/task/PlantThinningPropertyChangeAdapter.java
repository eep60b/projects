package com.etlsolutions.javafx.presentation.dialog.log.task;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Label;

/**
 *
 * @author zc
 */
public class PlantThinningPropertyChangeAdapter implements PropertyChangeListener {

    private final PlantThinningTaskDataModel model;
    private final Label thinningPlantRemainingLabel;

    public PlantThinningPropertyChangeAdapter(PlantThinningTaskDataModel model, Label thinningPlantRemainingLabel) {
        this.model = model;
        this.thinningPlantRemainingLabel = thinningPlantRemainingLabel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        thinningPlantRemainingLabel.setText(model.getRemainPlants());
    }
}
