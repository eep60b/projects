package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.menu.edit.observation.EditObservationEventHandler;
import com.etlsolutions.javafx.presentation.menu.edit.observation.EditObservationDataModel;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.FirstDateComparator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class EditPlantsObservationEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;
    private final ListView<GrowingObservation> listView;

    public EditPlantsObservationEventHandler(AddPlantsDataModel model, ListView<GrowingObservation> listView) {
        this.model = model;
        this.listView = listView;
    }

    @Override
    public void handle(ActionEvent event) {
        
        GrowingObservation observation = model.getSelectedGrowingObservation();
        EditObservationDataModel m = new EditObservationDataModel(observation);        
        EditObservationEventHandler handler = new EditObservationEventHandler(m);
        handler.handle(event);
        listView.getItems().set(listView.getSelectionModel().getSelectedIndex(), observation);
        listView.getItems().sort(new FirstDateComparator<GrowingObservation>());
    }
    
}
