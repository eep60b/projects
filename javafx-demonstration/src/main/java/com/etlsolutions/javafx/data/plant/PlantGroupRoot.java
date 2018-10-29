package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class PlantGroupRoot extends DataUnit {

    private ObservableListWrapperA<PlantGroup> plantGroups;

    public PlantGroupRoot() {
    }

    public PlantGroupRoot(String logoPath) {
        super("", "", new ObservableListWrapperA<ImageLink>(), 0, logoPath);
        plantGroups = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    public void setPlantGroups(ObservableListWrapperA<PlantGroup> plantGroups) {
        this.plantGroups = plantGroups;
    }
}
