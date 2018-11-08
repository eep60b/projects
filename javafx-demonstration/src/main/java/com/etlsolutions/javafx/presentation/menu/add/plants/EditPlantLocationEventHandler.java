package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.subarea.location.AddLocationDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.location.EditLocationDataModel;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditPlantLocationEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public EditPlantLocationEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {

        Location location = model.getLocation();

        if (model.getLocation() == null) {

            AddLocationDataModel addLocationDataModel = new AddLocationDataModel();
            FXMLActionEventHandler<AddLocationDataModel> eventHandler = new FXMLActionEventHandler<>(addLocationDataModel);
            eventHandler.handle(event);
            model.setLocation(addLocationDataModel.get());
            return;
        }
        
        ProjectManager m = ProjectManager.getInstance();
        SubArea subArea = (SubArea) m.getItem(location.getParentId());
        Area area = (Area) m.getItem(subArea.getParentId());
        EditLocationDataModel editLocationDataModel = new EditLocationDataModel(area, subArea, location);
        FXMLActionEventHandler<EditLocationDataModel> eventHandler = new FXMLActionEventHandler<>(editLocationDataModel);
        model.updateLocation();
    }
}
