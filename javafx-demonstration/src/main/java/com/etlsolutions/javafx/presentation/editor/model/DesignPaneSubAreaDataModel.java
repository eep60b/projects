package com.etlsolutions.javafx.presentation.editor.model;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.plant.PlantValueWrapper;
import javafx.geometry.Point2D;

/**
 *
 * @author ZhipengChang
 */
public class DesignPaneSubAreaDataModel {
    
    private final SubArea subArea;
    
    private final ObservableListWrapperA<PlantValueWrapper> plantSets = new ObservableListWrapperA<>();

    public DesignPaneSubAreaDataModel(SubArea subArea) {
        this.subArea = subArea;
    }

    public ObservableListWrapperA<PlantValueWrapper> getPlantSets() {
        return plantSets;
    }    
    
    public boolean isInMyArea(Point2D point) {
        return true;
    }    
}
