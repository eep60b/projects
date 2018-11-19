package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;

/**
 *
 * @author Zhipeng
 */
public class PatioAreaValueWrapper implements AreaSpecialValueWrapper {

    private final ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private final ObservableListWrapperA<Greenhouse> greenhouses;
    private final ObservableListWrapperA<SingleContainer> singleContainers;
    private final ObservableListWrapperA<ContainerSet> containerSets;
    private final ObservableListWrapperA<CustomSubArea> customSubareas;

    public PatioAreaValueWrapper(ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds, ObservableListWrapperA<Greenhouse> greenhouses, ObservableListWrapperA<SingleContainer> singleContainers, ObservableListWrapperA<ContainerSet> containerSets, ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.raisedPlantBeds = new ObservableListWrapperA<> (raisedPlantBeds);
        this.greenhouses = new ObservableListWrapperA<> (greenhouses);
        this.singleContainers = new ObservableListWrapperA<> (singleContainers);
        this.containerSets = new ObservableListWrapperA<> (containerSets);
        this.customSubareas = new ObservableListWrapperA<> (customSubareas);
    }

    public PatioAreaValueWrapper(PatioArea area) {
        this(area.getRaisedPlantBeds(), area.getGreenhouses(), area.getSingleContainers(), area.getContainerSets(), area.getCustomSubareas());
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
    public AreaType getType() {
        return AreaType.PATIO;
    }
}
