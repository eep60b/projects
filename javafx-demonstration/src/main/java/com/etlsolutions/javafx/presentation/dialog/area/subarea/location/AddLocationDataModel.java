package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

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
        set(LocationFactory.getInstance().createLocation(getValueWrapper(),measurementDataModel.getMeasurement()));
        selectedSubAreaValueWrapper.getValue().getLocations().add(get());
    }

    @Override
    public void remove(RemoveEventId id) {
        
        if(id == SELECTED_AREA_REMOVE_EVENT_ID) {
           ProjectManager.getInstance().getContents().getAreaRoot().remove(selectedAreaValueWrapper.getValue());
        }
        
        if(id == SELECTED_SUBAREA_REMOVE_EVENT_ID) {
            selectedAreaValueWrapper.getValue().remove(selectedSubAreaValueWrapper.getValue());
        }
        
        super.remove(id);
    }
}
