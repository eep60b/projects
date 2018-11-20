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
    
    public AreaValueWrapper(Area area) {
        
        longitudeValueWrapper = new ValueWrapper<>(String.valueOf(area.getLongitude()));
        latitudeValueWrapper = new ValueWrapper<>(String.valueOf(area.getLatitude()));
        shapeValueWrapper = new ValueWrapper<>(area.getShape());
        
    }

    public AreaValueWrapper() {
        
        longitudeValueWrapper = new ValueWrapper<>("0");
        latitudeValueWrapper = new ValueWrapper<>("0");
        shapeValueWrapper = new ValueWrapper<>(AreaShape.RECTANGLE);        
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
