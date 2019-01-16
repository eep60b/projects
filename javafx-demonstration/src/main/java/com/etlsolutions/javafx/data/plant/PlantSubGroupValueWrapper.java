package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class PlantSubGroupValueWrapper extends DataUnitValueWrapper {
    
    private final ValueWrapper<PlantGroup> plantGroupValueWrapper;
    private final ObservableListWrapperA<Plants> plants;
    private final ObservableListWrapperA<PlantVariety> plantVarieties;

    public PlantSubGroupValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, PlantGroup group, ObservableListWrapperA<Plants> plants, ObservableListWrapperA<PlantVariety> plantVarieties) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        plantGroupValueWrapper = new ValueWrapper<>(group);
        this.plants = new ObservableListWrapperA<>(plants);
        this.plantVarieties = new ObservableListWrapperA<>(plantVarieties);
    }

    public PlantSubGroupValueWrapper(PlantSubGroup subGroup) {
        super(subGroup);
        plantGroupValueWrapper = new ValueWrapper<>(ProjectManager.getInstance().<PlantGroup>getItem(subGroup.getId())); 
        plants = new ObservableListWrapperA<>(subGroup.getPlants());
        plantVarieties = new ObservableListWrapperA<>(subGroup.getPlantVarieties());
    }

    public ValueWrapper<PlantGroup> getPlantGroupValueWrapper() {
        return plantGroupValueWrapper;
    }
    
    public ObservableListWrapperA<Plants> getPlants() {
        return plants;
    }

    public ObservableListWrapperA<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }    
}
