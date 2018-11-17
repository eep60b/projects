package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;

/**
 *
 * @author Zhipeng
 */
public class AllotmentAreaValueWrapper implements AreaSpecialValueWrapper {

    private final ObservableListWrapperA<PlantBed> plantBeds;
    private final ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private final ObservableListWrapperA<Border> borders;
    private final ObservableListWrapperA<Greenhouse> greenhouses;
    private final ObservableListWrapperA<CustomSubArea> customSubareas;

    public AllotmentAreaValueWrapper(ObservableListWrapperA<PlantBed> plantBeds, ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds, ObservableListWrapperA<Border> borders, ObservableListWrapperA<Greenhouse> greenhouses, ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.plantBeds = new ObservableListWrapperA<>(plantBeds);
        this.raisedPlantBeds = new ObservableListWrapperA<>(raisedPlantBeds);
        this.borders = new ObservableListWrapperA<>(borders);
        this.greenhouses = new ObservableListWrapperA<>(greenhouses);
        this.customSubareas = new ObservableListWrapperA<>(customSubareas);
    }

    public AllotmentAreaValueWrapper(AllotmentArea area) {
        this(area.getPlantBeds(), area.getRaisedPlantBeds(), area.getBorders(), area.getGreenhouses(), area.getCustomSubareas());
    }

    public ObservableListWrapperA<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public ObservableListWrapperA<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableListWrapperA<Border> getBorders() {
        return borders;
    }

    public ObservableListWrapperA<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }
    
    @Override
    public AreaType getType() {
        return AreaType.ALLOTMENT;
    }
}