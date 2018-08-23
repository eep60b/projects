package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.CustomSubarea;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class CustomArea extends Area {

    @JsonIgnore
    public static final String CUSTOM_SUBAREAS_PROPERTY = "com.etlsolutions.javafx.data.area.CustomArea.CUSTOM_SUBAREAS_PROPERTY";
    
    private List<CustomSubarea> customSubareas;

    public List<CustomSubarea> getCustomSubareas() {
        return new ArrayList<>(customSubareas);
    }

    public void setCustomSubareas(List<CustomSubarea> customSubareas) {
        this.customSubareas = new ArrayList<>(customSubareas);
        fireChange(CUSTOM_SUBAREAS_PROPERTY);
    }

    public boolean addSubarea(CustomSubarea subarea) {
        boolean added = customSubareas.add(subarea);
        fireChange(CUSTOM_SUBAREAS_PROPERTY, false, added);
        return added;
    }

    public boolean removeSubarea(CustomSubarea subarea) {
        boolean removed = customSubareas.remove(subarea);
        fireChange(CUSTOM_SUBAREAS_PROPERTY, false, removed);
        return removed;
    }
   
    @Override
    public boolean isEmpty() {
        return customSubareas.isEmpty();
    }
}
