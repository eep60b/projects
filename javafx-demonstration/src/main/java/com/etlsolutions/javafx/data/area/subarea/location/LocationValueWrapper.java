package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class LocationValueWrapper {

    private final ValueWrapper<LocationType> typeValueWrapper;
    private final ValueWrapper<Integer> plantIdValueWrapper;
    private final ValueWrapper<Integer> parentIdValueWrapper;

    public LocationValueWrapper(Location location) {
        plantIdValueWrapper = new ValueWrapper<>(location.getPlantId());
        parentIdValueWrapper = new ValueWrapper<>(location.getParentId());
        typeValueWrapper = new ValueWrapper<>(location.getType());
    }    
    
    public LocationValueWrapper() {
        plantIdValueWrapper = new ValueWrapper<>(0);
        parentIdValueWrapper = new ValueWrapper<>(0);
        typeValueWrapper = new ValueWrapper<>(LocationType.PLANT_BED_LOCATION);
    }

    public LocationValueWrapper(LocationType type, int plantId, int parentId) {
        this.typeValueWrapper = new ValueWrapper<>(type);
        this.plantIdValueWrapper = new ValueWrapper<>(plantId);
        this.parentIdValueWrapper = new ValueWrapper<>(parentId);
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
