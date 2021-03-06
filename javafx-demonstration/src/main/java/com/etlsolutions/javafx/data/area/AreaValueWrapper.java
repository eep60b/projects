package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author Zhipeng
 */
public class AreaValueWrapper extends DataUnitValueWrapper {

    private final ValueWrapper<String> longitudeValueWrapper;
    private final ValueWrapper<String> latitudeValueWrapper;
    private final ValueWrapper<GwiseShapeType> shapeValueWrapper;
    
    public AreaValueWrapper(Area area) {
        super(area);
        longitudeValueWrapper = getWrapper(area.getLongitude());
        latitudeValueWrapper = getWrapper(area.getLatitude());
        shapeValueWrapper = new ValueWrapper<>(area.getShapeType());
        
    }

    public AreaValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, double longitude, double latitude, GwiseShapeType shape) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        longitudeValueWrapper = getWrapper(latitude);
        latitudeValueWrapper = getWrapper(longitude);
        shapeValueWrapper = new ValueWrapper<>(GwiseShapeType.RECTANGLE);  
    }

    public ValueWrapper<String> getLongitudeValueWrapper() {
        return longitudeValueWrapper;
    }

    public ValueWrapper<String> getLatitudeValueWrapper() {
        return latitudeValueWrapper;
    }

    public ValueWrapper<GwiseShapeType> getShapeValueWrapper() {
        return shapeValueWrapper;
    }
    
    public double getLongitude() {
        return getValue(longitudeValueWrapper);
    }

    public double getLatitude() {
        return getValue(latitudeValueWrapper);
    }

    public GwiseShapeType getShape() {
        return shapeValueWrapper.getValue();
    }    
}
