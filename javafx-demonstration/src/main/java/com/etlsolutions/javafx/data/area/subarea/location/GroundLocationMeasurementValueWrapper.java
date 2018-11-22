package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class GroundLocationMeasurementValueWrapper extends DoubleValueWrapper implements LocationSpecialValueWrapper {

    private final ValueWrapper<String> referencePointValueWrapper;
    private final ValueWrapper<String> directionValueWrapper;
    private final ValueWrapper<String> distanceValueWrapper;
    private final ValueWrapper<String> occupiedAreaValueWrapper;

    public GroundLocationMeasurementValueWrapper(GroundLocationMeasurement measurement) {
        referencePointValueWrapper = new ValueWrapper<>(measurement.getReferencePoint());
        directionValueWrapper = new ValueWrapper<>(measurement.getDirection());
        distanceValueWrapper = getWrapper(measurement.getDistance());
        occupiedAreaValueWrapper = getWrapper(measurement.getOccupiedArea());
    }
    
    public GroundLocationMeasurementValueWrapper() {
        this(new GroundLocationMeasurement());
    }

    public ValueWrapper<String> getReferencePointValueWrapper() {
        return referencePointValueWrapper;
    }

    public ValueWrapper<String> getDirectionValueWrapper() {
        return directionValueWrapper;
    }

    public ValueWrapper<String> getDistanceValueWrapper() {
        return distanceValueWrapper;
    }

    public ValueWrapper<String> getOccupiedAreaValueWrapper() {
        return occupiedAreaValueWrapper;
    }

    public double getDistance() {
        return getValue(distanceValueWrapper);
    }


    public double getOccupiedArea() {
        return getValue(occupiedAreaValueWrapper);
    }

    public GroundLocationMeasurement getMeasurement() {
        return new GroundLocationMeasurement(this);
    }
    
    @Override
    public ValueWrapper<LocationMeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(LocationMeasurementType.GROUND_LOCATION);
    }

}
