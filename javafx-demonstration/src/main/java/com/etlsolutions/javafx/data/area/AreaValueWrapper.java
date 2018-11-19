package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author Zhipeng
 */
public class AreaValueWrapper {

    private final ValueWrapper<String> longitudeValueWrapper;
    private final ValueWrapper<String> latitudeValueWrapper;
    private final ValueWrapper<AreaShape> shapeValueWrapper;

    public AreaValueWrapper(double longitude, double latitude, AreaShape shape) {
        
        this.longitudeValueWrapper = new ValueWrapper<>(String.valueOf(longitude));
        this.latitudeValueWrapper = new ValueWrapper<>(String.valueOf(latitude));
        this.shapeValueWrapper = new ValueWrapper<>(shape);
        
    }


    public ValueWrapper<String> getLongitudeValueWrapper() {
        return longitudeValueWrapper;
    }

    public ValueWrapper<String> getLatitudeValueWrapper() {
        return latitudeValueWrapper;
    }

    public ValueWrapper<AreaShape> getShapeValueWrapper() {
        return shapeValueWrapper;
    }
    
    public double getLongitude() {
        return getValue(longitudeValueWrapper);
    }

    public double getLatitude() {
        return getValue(latitudeValueWrapper);
    }

    public AreaShape getShape() {
        return shapeValueWrapper.getValue();
    }
    
    private double getValue(ValueWrapper<String> wrapper) {
        return Double.parseDouble(wrapper.getValue());
    }
    
}
