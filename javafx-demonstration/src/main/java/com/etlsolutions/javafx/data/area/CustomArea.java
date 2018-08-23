package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.Subarea;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class CustomArea extends Area {

    @JsonIgnore
    public static final String SUBAREAS_PROPERTY = "com.etlsolutions.javafx.data.area.CustomArea.SUBAREAS_PROPERTY";
    
    private List<Subarea> subareas;

    public List<Subarea> getSubareas() {
        return new ArrayList<>(subareas);
    }

    public void setSubareas(List<Subarea> subareas) {
        this.subareas = new ArrayList<>(subareas);
        fireChange(SUBAREAS_PROPERTY);
    }

    public boolean addSubarea(Subarea subarea) {
        boolean added = subareas.add(subarea);
        fireChange(SUBAREAS_PROPERTY, false, added);
        return added;
    }

    public boolean removeSubarea(Subarea subarea) {
        boolean removed = subareas.remove(subarea);
        fireChange(SUBAREAS_PROPERTY, false, removed);
        return removed;
    }
   
    @Override
    public boolean isEmpty() {
        return subareas.isEmpty();
    }
}
