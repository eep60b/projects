package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.menu.add.gvent.EditGventDataModel;
import com.etlsolutions.javafx.data.log.FirstDateComparator;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class EditPlantsGventEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;
    private final ListView<Gvent> listView;

    public EditPlantsGventEventHandler(AddPlantsDataModel model, ListView<Gvent> listView) {
        this.model = model;
        this.listView = listView;
    }

    @Override
    public void handle(ActionEvent event) {
        
        Gvent e = model.getSelectedEventValueWrapper().getValue();
        EditGventDataModel m = new EditGventDataModel(e);        
        FXMLActionEventHandler<EditGventDataModel> handler = new FXMLActionEventHandler<>(m);
        handler.handle(event);
        listView.getItems().sort(new FirstDateComparator<Gvent>());
    }
    
}
