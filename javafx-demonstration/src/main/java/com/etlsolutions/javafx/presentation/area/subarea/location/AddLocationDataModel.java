package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationFactory;
import com.etlsolutions.javafx.data.area.subarea.location.LocationReferencePoint;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddLocationDataModel extends AbstractLocationDataModel {

    public static final RemoveEventId SELECTED_AREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.location.LocationDataModel.selectedArea", "selected area");
    public static final RemoveEventId SELECTED_SUBAREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.location.LocationDataModel.selectedSubArea", "selected area part");

    public AddLocationDataModel() {
        super(ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas(),
                ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas().get(0).getAllSubAreas(),
                ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas().get(0).getAllSubAreas().get(0).getType().getLocationTypes());

        location = LocationFactory.getInstance().getDefaultLocation();
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(RemoveEventId id) {
        super.remove(id);
    }

    @Override
    protected void validate() {

        if (selectedType == null) {
            valid = false;
            errorMessage = "Create an area part for the location.";
        }

        super.validate();
    }

}
