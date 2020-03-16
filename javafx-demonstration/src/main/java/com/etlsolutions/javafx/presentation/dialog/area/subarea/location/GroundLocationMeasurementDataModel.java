package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.GroundLocationMeasurementValueWrapper;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.gwise.system.ProjectManager;

/**
 *
 * @author zc
 */
public class GroundLocationMeasurementDataModel extends LocationMeasurementDataModel<GroundLocationMeasurementValueWrapper> {

    private final ObservableListWrapperA<String> referencePoints;
    private final ObservableListWrapperA<String> directions;

    public GroundLocationMeasurementDataModel(GroundLocationMeasurementValueWrapper valueWrapper) {
        super(valueWrapper);
        ProjectContents project = ProjectManager.getInstance().getContents();
        referencePoints = new ObservableListWrapperA<>(project.getLocationReferencePoints());
        directions = new ObservableListWrapperA<>(project.getLocationDirections());
    }

    public ValueWrapper<String> getReferencePointValueWrapper() {
        return valueWrapper.getReferencePointValueWrapper();
    }

    public ValueWrapper<String> getDirectionValueWrapper() {
        return valueWrapper.getDirectionValueWrapper();
    }

    public ValueWrapper<String> getDistanceValueWrapper() {
        return valueWrapper.getDistanceValueWrapper();
    }

    public ValueWrapper<String> getOccupiedAreaValueWrapper() {
        return valueWrapper.getOccupiedAreaValueWrapper();
    }

    public ObservableListWrapperA<String> getReferencePoints() {
        return referencePoints;
    }

    public ObservableListWrapperA<String> getDirections() {
        return directions;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/GroundLocationFXML.fxml";
    }
}
