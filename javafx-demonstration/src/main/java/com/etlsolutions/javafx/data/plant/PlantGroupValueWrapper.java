package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class PlantGroupValueWrapper extends DataUnitValueWrapper {

    private final ObservableListWrapperA<PlantSubGroup> plantsSubGroups;

    public PlantGroupValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, ObservableListWrapperA<PlantSubGroup> plantsSubGroups) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plantsSubGroups = new ObservableListWrapperA<>(plantsSubGroups);
    }

    public PlantGroupValueWrapper(PlantGroup group) {
        super(group);
        this.plantsSubGroups = new ObservableListWrapperA<>(group.getPlantSubGroups());
    }

    public ObservableListWrapperA<PlantSubGroup> getPlantsSubGroups() {
        return plantsSubGroups;
    }    
}
