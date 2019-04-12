
package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class PolygonMeasurement  implements Measurement {

    private double[] coordinates;

    
    
    public PolygonMeasurement() {
    }
    
    public PolygonMeasurement(PolygonMeasurementWrapper wrapper) {
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
    
    
    @Override
    public MeasurementType getType() {
        return MeasurementType.POLYGON;
    }
    
}
