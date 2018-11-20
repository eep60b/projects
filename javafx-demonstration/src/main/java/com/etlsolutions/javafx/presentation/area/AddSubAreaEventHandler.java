package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.subarea.CreateSubAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 *
 * @author Zhipeng
 */
public class AddSubAreaEventHandler implements EventHandler<ActionEvent> {

    private final AbstractAreaDataModel model;
    private final ListView<SubArea> subAreaListView;

    public AddSubAreaEventHandler(AbstractAreaDataModel model, ListView<SubArea> subAreaListView) {
        this.model = model;
        this.subAreaListView = subAreaListView;
    }

    @Override
    public void handle(ActionEvent event) {
        CreateSubAreaDataModel subAreaDataModel = new CreateSubAreaDataModel(model.getSelectedAreaType().getSubAreaTypes());
        new FXMLActionEventHandler<>(subAreaDataModel).handle(event);
        SubArea subArea = subAreaDataModel.get();
        model.getSubAreas().add(subArea);
        model.setSelectedSubArea(subArea);
        subAreaListView.setItems(model.getSubAreas());
        subAreaListView.getSelectionModel().select(subArea);
    }
    
}
