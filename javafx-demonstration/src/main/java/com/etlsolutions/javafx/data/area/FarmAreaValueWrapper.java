package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;

/**
 *
 * @author Zhipeng
 */
public class FarmAreaValueWrapper implements AreaSpecialValueWrapper {

    private final ObservableListWrapperA<PlantBed> plantBeds;
    private final ObservableListWrapperA<Border> borders;
    private final ObservableListWrapperA<CustomSubArea> customSubareas;

    public FarmAreaValueWrapper(ObservableListWrapperA<PlantBed> plantBeds, ObservableListWrapperA<Border> borders, ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.plantBeds = new ObservableListWrapperA<>(plantBeds);
        this.borders = new ObservableListWrapperA<>(borders);
        this.customSubareas = new ObservableListWrapperA<>(customSubareas);
    }

    public FarmAreaValueWrapper(FarmArea area) {
        this(area.getPlantBeds(), area.getBorders(), area.getCustomSubareas());
    }

    public ObservableListWrapperA<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public ObservableListWrapperA<Border> getBorders() {
        return borders;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public AreaType getType() {
        return AreaType.FARM;
    }
}
