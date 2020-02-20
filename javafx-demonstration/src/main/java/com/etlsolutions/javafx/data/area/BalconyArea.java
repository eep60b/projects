package com.etlsolutions.javafx.data.area;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class BalconyArea extends Area {

    private ObservableListWrapperA<ContainerSet> containerSets;
    private ObservableListWrapperA<SingleContainer> singleContainers;
    private ObservableListWrapperA<CustomSubArea> customSubareas;

    public BalconyArea() {
    }

    public BalconyArea(AreaValueWrapper areaValueWrapper, ObservableListWrapperA<SubArea> subAreas, MeasurementValueWrapper measurementValueWrapper) {
        super(areaValueWrapper, measurementValueWrapper, subAreas);
    }

    public ObservableListWrapperA<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public void setContainerSets(ObservableListWrapperA<ContainerSet> containerSets) {
        this.containerSets = containerSets;
    }

    public ObservableListWrapperA<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public void setSingleContainers(ObservableListWrapperA<SingleContainer> singleContainers) {
        this.singleContainers = singleContainers;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    public void setCustomSubareas(ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.customSubareas = customSubareas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getAllSubAreas() {

        ObservableListWrapperA<SubArea> sas = new ObservableListWrapperA<>();
        sas.addAll(containerSets);
        sas.addAll(singleContainers);
        sas.addAll(customSubareas);
        return sas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type) {
        switch (type) {
            case CONTAINTER_SET:
                return new ObservableListWrapperA<SubArea>(containerSets);
            case SINGLE_CONTAINTER:
                return new ObservableListWrapperA<SubArea>(singleContainers);
            case CUSTOM:
                return new ObservableListWrapperA<SubArea>(customSubareas);
            default:
                return new ObservableListWrapperA<>();
        }
    }

    @Override
    public AreaType getType() {
        return AreaType.BALCONY;
    }

    @Override
    public void remove(SubArea selectedSubArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
