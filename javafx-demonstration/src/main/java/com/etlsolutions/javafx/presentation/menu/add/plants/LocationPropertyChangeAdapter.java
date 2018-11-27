package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author zc
 */
class LocationPropertyChangeAdapter implements PropertyChangeListener {

    private final Label locationTitleTabel;
    private final TextArea locationInformationTextArea;
    private final Button editLocationButton;

    public LocationPropertyChangeAdapter(Label locationTitleLabel, TextArea locationInformationTextArea, Button editLocationButton) {
        
        this.locationTitleTabel = locationTitleLabel;
        this.locationInformationTextArea = locationInformationTextArea;
        this.editLocationButton = editLocationButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AddPlantsDataModel model = (AddPlantsDataModel)evt.getSource();
        Location location = model.getLocation();
        locationTitleTabel.setText(location == null ? "Not Specified" : location.getTitle());
        locationInformationTextArea.setText(location == null ? "" : location.getInformation());
        editLocationButton.setText(location == null ? "Add Location" : "Edit Location");
    }
    
}
