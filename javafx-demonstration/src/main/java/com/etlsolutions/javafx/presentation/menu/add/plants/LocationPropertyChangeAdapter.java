package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author zc
 */
class LocationPropertyChangeAdapter implements PropertyChangeListener {

    private final TextField locationTitleTextField;
    private final TextArea locationInformationTextArea;
    private final Button editLocationButton;

    public LocationPropertyChangeAdapter(TextField locationTitleTextField, TextArea locationInformationTextArea, Button editLocationButton) {
        
        this.locationTitleTextField = locationTitleTextField;
        this.locationInformationTextArea = locationInformationTextArea;
        this.editLocationButton = editLocationButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AddPlantsDataModel model = (AddPlantsDataModel)evt.getSource();
        Location location = model.getLocation();
        locationTitleTextField.setText(location == null ? "Not Specified" : location.getTitle());
        locationInformationTextArea.setText(location == null ? "" : location.getInformation());
        editLocationButton.setText(location == null ? "Add Location" : "Edit Location");
    }
    
}
