package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.Lawn;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Pond;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;

/**
 *
 * @author Zhipeng
 */
public class GardenAreaValueWrapper {

    private ObservableListWrapperA<PlantBed> plantBeds;
    private ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private ObservableListWrapperA<Lawn> lawns;
    private ObservableListWrapperA<Border> borders;
    private ObservableListWrapperA<Greenhouse> greenhouses;
    private ObservableListWrapperA<ContainerSet> containerSets;
    private ObservableListWrapperA<SingleContainer> singleContainers;
    private ObservableListWrapperA<Pond> ponds;
    private ObservableListWrapperA<CustomSubArea> customSubareas;
}
