package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationFactory;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddLocationDataModel extends AbstractLocationDataModel {

    public static final RemoveEventId SELECTED_AREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.location.LocationDataModel.selectedArea", "selected area");
    public static final RemoveEventId SELECTED_SUBAREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.location.LocationDataModel.selectedSubArea", "selected area part");

    public AddLocationDataModel(int plantId) {
        super(plantId);
    }

    @Override
    public void save() {
        dataUnit = LocationFactory.getInstance().createLocation(commonValueWrapper, locationValueWrapper, measurementDataModel.getValue());
        selectedSubArea.getValue().getLocations(selectedType.getValue()).add(dataUnit);
    }

    @Override
    public void remove(RemoveEventId id) {
        
        if(id == SELECTED_AREA_REMOVE_EVENT_ID) {
           ProjectManager.getInstance().getContents().getAreaRoot().remove(selectedArea.getValue());
        }
        
        if(id == SELECTED_SUBAREA_REMOVE_EVENT_ID) {
            selectedArea.getValue().remove(selectedSubArea.getValue());
        }
        
        super.remove(id);
    }

    @Override
    protected void validate() {

        if (selectedType == null) {
            invalid = false;
            errorMessage = "Create an area part for the location.";
        }

        super.validate();
    }
}
