package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;

/**
 *
 * @author zc
 */
public class PatioArea extends Area {

    private ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private ObservableListWrapperA<Greenhouse> greenhouses;
    private ObservableListWrapperA<SingleContainer> singleContainers;
    private ObservableListWrapperA<ContainerSet> containerSets;
    private ObservableListWrapperA<CustomSubArea> customSubareas;

    public PatioArea() {

    }

    public PatioArea(DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, SubAreaListValueWrapper subAreas, MeasurementValueWrapper measurementValueWrapper) {
        super(valueWrapper, areaValueWrapper, measurementValueWrapper);
        raisedPlantBeds = new ObservableListWrapperA<>(subAreas.getRaisedPlantBeds());
        greenhouses = new ObservableListWrapperA<>(subAreas.getGreenhouses());
        singleContainers = new ObservableListWrapperA<>(subAreas.getSingleContainers());
        containerSets = new ObservableListWrapperA<>(subAreas.getContainerSets());
        customSubareas = new ObservableListWrapperA<>(subAreas.getCustomSubareas());
    }

    public ObservableListWrapperA<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableListWrapperA<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableListWrapperA<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableListWrapperA<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getAllSubAreas() {
        
        ObservableListWrapperA<SubArea> allSubAreas = new ObservableListWrapperA<>();
        allSubAreas.addAll(raisedPlantBeds);
        allSubAreas.addAll(greenhouses);
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(customSubareas);
        return allSubAreas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type) {
               ObservableListWrapperA<SubArea> subAreas = new ObservableListWrapperA<>();
        switch (type) {
            case RAISED_PLANT_BED:
                subAreas.addAll(raisedPlantBeds);
                break;

            case GREEN_HOUSE:
                subAreas.addAll(greenhouses);
                break;

            case CONTAINTER_SET:
                subAreas.addAll(containerSets);
                break;

            case SINGLE_CONTAINTER:
                subAreas.addAll(singleContainers);
                break;
                
            case CUSTOM:
                subAreas.addAll(customSubareas);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.PATIO;
    }
}
