package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.location.AddLocationDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.location.EditLocationDataModel;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author zc
 */
public class EditPlantLocationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractPlantDataModel model;
    private final Label locationTitleLabel;
    private final TextArea locationInformationTextArea;

    public EditPlantLocationEventHandler(AbstractPlantDataModel model, Label locationTitleLabel, TextArea locationInformationTextArea) {
        this.model = model;
        this.locationTitleLabel = locationTitleLabel;
        this.locationInformationTextArea = locationInformationTextArea;
    }

    @Override
    public void handle(ActionEvent event) {

        Location location = model.getLocationValueWrapper().getValue();

        if (location == null) {

            AddLocationDataModel addLocationDataModel = new AddLocationDataModel(model.get() == null ? 0 : model.get().getId());
            FXMLActionEventHandler<AddLocationDataModel> eventHandler = new FXMLActionEventHandler<>(addLocationDataModel);
            eventHandler.handle(event);
            if (addLocationDataModel.get() != null) {
                model.getLocationValueWrapper().setValue(addLocationDataModel.get());
            }
            return;
        }

        ProjectManager m = ProjectManager.getInstance();
        SubArea subArea = (SubArea) m.getItem(location.getParentId());
        Area area = (Area) m.getItem(subArea.getParentId());
        EditLocationDataModel editLocationDataModel = new EditLocationDataModel(area, subArea, location);
        FXMLActionEventHandler<EditLocationDataModel> eventHandler = new FXMLActionEventHandler<>(editLocationDataModel);
        eventHandler.handle(event);
        locationTitleLabel.setText(location.getTitle());
        locationInformationTextArea.setText(location.getInformation());
    }
}
