package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.SubArea;

/**
 *
 * @author Zhipeng
 */
public class AreaValueWrapper {

    private final ObservableListWrapperA<SubArea> allSubAreas;
    private final ValueWrapper<String> longitudeValueWrapper;
    private final ValueWrapper<String> latitudeValueWrapper;
    private final ValueWrapper<AreaShape> shapeValueWrapper;

    public AreaValueWrapper(ObservableListWrapperA<SubArea> allSubAreas, double longitude, double latitude, AreaShape shape) {
        this.allSubAreas = new ObservableListWrapperA<>(allSubAreas);
        this.longitudeValueWrapper = new ValueWrapper<>(String.valueOf(longitude));
        this.latitudeValueWrapper = new ValueWrapper<>(String.valueOf(latitude));
        this.shapeValueWrapper = new ValueWrapper<>(shape);
    }

    public ObservableListWrapperA<SubArea> getAllSubAreas() {
        return allSubAreas;
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
