package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.log.gvent.EditGventDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class PlantObservationPropertyChangeAdapter implements PropertyChangeListener {

    private final ListView<Gvent> gventListView;
    private final Button editGventButton;
    private final Button removeGventButton;

    PlantObservationPropertyChangeAdapter(ListView<Gvent> gventListView, Button editGventButton, Button removeGventButton) {
        this.gventListView = gventListView;
        this.editGventButton = editGventButton;
        this.removeGventButton = removeGventButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process((ValueWrapper<Gvent>) evt.getSource());
    }

    public void process(ValueWrapper<Gvent> wrapper) {
        boolean hasGvent = wrapper.getValue() != null;
        editGventButton.setDisable(!hasGvent);
        removeGventButton.setDisable(!hasGvent);
        if (hasGvent) {
            EditGventDataModel gm = new EditGventDataModel(wrapper.getValue());
            gm.addPropertyChangeListener(EditGventDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(gventListView));
            editGventButton.setOnAction(new EditItemEventHandler(gm));
        }
    }
}
