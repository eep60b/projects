package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.menu.edit.gvent.EditGventDataModel;
import com.etlsolutions.javafx.data.log.FirstDateComparator;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.presentation.AbstractActionEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class EditPlantsEventEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;
    private final ListView<Gvent> listView;

    public EditPlantsEventEventHandler(AddPlantsDataModel model, ListView<Gvent> listView) {
        this.model = model;
        this.listView = listView;
    }

    @Override
    public void handle(ActionEvent event) {
        
        Gvent e = model.getSelectedEvent();
        EditGventDataModel m = new EditGventDataModel(e);        
        AbstractActionEventHandler<EditGventDataModel> handler = new AbstractActionEventHandler<>(m);
        handler.handle(event);
        listView.getItems().set( listView.getSelectionModel().getSelectedIndex(), e);
        listView.getItems().sort(new FirstDateComparator<Gvent>());
    }
    
}
