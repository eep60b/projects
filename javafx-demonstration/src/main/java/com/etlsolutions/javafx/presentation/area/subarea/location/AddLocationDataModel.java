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

    @Override
    public void save() {
        item = LocationFactory.getInstance().createLocation(selectedType);
        selectedSubArea.getLocations(selectedType).add(item);
    }

    @Override
    public void remove(RemoveEventId id) {
        
        if(id == SELECTED_AREA_REMOVE_EVENT_ID) {
           ProjectManager.getInstance().getContents().getAreaRoot().remove(selectedArea);
        }
        
        if(id == SELECTED_SUBAREA_REMOVE_EVENT_ID) {
            selectedArea.remove(selectedSubArea);
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
