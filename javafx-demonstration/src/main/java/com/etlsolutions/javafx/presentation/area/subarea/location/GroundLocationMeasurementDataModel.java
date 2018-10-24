package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.GroundLocationMeasurement;

/**
 *
 * @author zc
 */
public class GroundLocationMeasurementDataModel extends LocationMeasurementDataModel<GroundLocationMeasurement> {

    public GroundLocationMeasurementDataModel(GroundLocationMeasurement measurement) {
        super(measurement);
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
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/GroundLocationFXML.fxml";
    }
}
