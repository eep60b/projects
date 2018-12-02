package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.log.growingobservation.EditGrowingObservationDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class PlantObservationPropertyChangeAdapter implements PropertyChangeListener {

    private final ListView<GrowingObservation> growingObservationListView;
    private final Button editGrowingObservationButton;
    private final Button removeGrowingObservationButton;

    PlantObservationPropertyChangeAdapter(ListView<GrowingObservation> gventListView, Button editGrowingObservationButton, Button removeGrowingObservationButton) {
        this.growingObservationListView = gventListView;
        this.editGrowingObservationButton = editGrowingObservationButton;
        this.removeGrowingObservationButton = removeGrowingObservationButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process((ValueWrapper<GrowingObservation>) evt.getSource());
    }

    public void process(ValueWrapper<GrowingObservation> wrapper) {
        boolean hasGrowingObservation = wrapper.getValue() != null;
        editGrowingObservationButton.setDisable(!hasGrowingObservation);
        removeGrowingObservationButton.setDisable(!hasGrowingObservation);
        if (hasGrowingObservation) {
            EditGrowingObservationDataModel gm = new EditGrowingObservationDataModel(wrapper.getValue());
            gm.addPropertyChangeListener(EditGrowingObservationDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(growingObservationListView));
            editGrowingObservationButton.setOnAction(new EditItemEventHandler(gm));
        }
    }
}
