package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.GroundLocationMeasurement;
import com.etlsolutions.javafx.system.ProjectConfiguration;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class GroundLocationMeasurementDataModel extends LocationMeasurementDataModel<GroundLocationMeasurement> {

    private final ObservableListWrapperA<String> referencePoints;
    private final ObservableListWrapperA<String> directions;
    
    public GroundLocationMeasurementDataModel(GroundLocationMeasurement measurement) {
        super(measurement);
        ProjectConfiguration project = ProjectManager.getInstance().getProject();
        referencePoints = new ObservableListWrapperA<>(project.getLocationReferencePoints());
        directions = new ObservableListWrapperA<>(project.getLocationDirections());
    }

    public String getReferencePoint() {
        return measurement.getReferencePoint().getTitle();
    }

    public void setReferencePoint(String referencePoint) {
        measurement.getReferencePoint().setTitle(referencePoint);
    }

    public String getDirection() {
        return measurement.getDirection().getTitle();
    }

    public void setDirection(String direction) {
        measurement.getDirection().setTitle(direction);
    }

    public String getDistance() {
        return String.valueOf(measurement.getDistance());
    }

    public void setDistance(String distance) {
        measurement.setDistance(Double.parseDouble(distance));
    }

    public String getOccupiedArea() {
        return String.valueOf(measurement.getOccupiedArea());
    }

    public void setOccupiedArea(String occupiedArea) {
        measurement.setOccupiedArea(Double.parseDouble(occupiedArea));
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
