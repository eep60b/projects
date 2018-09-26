package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.SubAreaK;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class CustomArea extends Area {
    
    private final ObservableList<SubAreaK> customSubareas;

    public CustomArea() {
        
        customSubareas = FXCollections.observableArrayList();
    }

    public ObservableList<SubAreaK> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public void updateAllSubAreas() {
        allSubAreas.addAll(customSubareas);
    }
}
