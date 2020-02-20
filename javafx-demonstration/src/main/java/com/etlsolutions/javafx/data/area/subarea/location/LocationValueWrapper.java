package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class LocationValueWrapper extends DataUnitValueWrapper {

    private final ValueWrapper<LocationType> typeValueWrapper;
    private final ValueWrapper<Integer> plantIdValueWrapper;
    private final ValueWrapper<Integer> parentIdValueWrapper;

    public LocationValueWrapper(Location location) {
        super(location);
        plantIdValueWrapper = new ValueWrapper<>(location.getPlantId());
        parentIdValueWrapper = new ValueWrapper<>(location.getParentId());
        typeValueWrapper = new ValueWrapper<>(location.getType());
    }    
    
    public LocationValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocationType type, int plantId, int parentId) {
        
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        typeValueWrapper = new ValueWrapper<>(type);
        plantIdValueWrapper = new ValueWrapper<>(plantId);
        parentIdValueWrapper = new ValueWrapper<>(parentId);
    }

    public ValueWrapper<LocationType> getTypeValueWrapper() {
        return typeValueWrapper;
    }

    public ValueWrapper<Integer> getPlantIdValueWrapper() {
        return plantIdValueWrapper;
    }

    public ValueWrapper<Integer> getParentIdValueWrapper() {
        return parentIdValueWrapper;
    }    
}
