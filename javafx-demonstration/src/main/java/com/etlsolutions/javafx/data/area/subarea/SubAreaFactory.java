package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class SubAreaFactory {

    private static final SubAreaFactory INSTANCE = new SubAreaFactory();

    public static final SubAreaFactory getInstance() {
        return INSTANCE;
    }

    public ContainerSet createContainerSet() {
        ContainerSet s = new ContainerSet();
        return s;
    }

    public static CustomSubArea createCustomSubarea() {
        CustomSubArea s = new CustomSubArea();
        return s;
    }

    public static Greenhouse createGreenhouse() {
        Greenhouse g = new Greenhouse();
        return g;
    }

    public static PlantBed createPlantBed() {
        PlantBed b = new PlantBed();
        return b;
    }

    public static Border createPlantBedBorder() {

        Border b = new Border();
        return b;
    }

    public static Pond createPond() {
        Pond p = new Pond();
        return p;
    }

    public static RaisedPlantBed createRaisedPlantBed() {
        RaisedPlantBed r = new RaisedPlantBed();
        return r;
    }

    public static Room createRoom() {
        Room r = new Room();
        return r;
    }

    public SubArea createSubArea(SubAreaType selectedSubAreaType, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int indexOf, String string, SubAreaShape selectedSubAreaShape, SubAreaMeasurement measurement) {
        switch (selectedSubAreaType) {
            case BORDER:
                return new Border();
            case CONTAINTER_SET:
                return new ContainerSet();
            case CUSTOM:
                return new CustomSubArea(measurement, selectedSubAreaShape, title, information, imageLinks, indexOf, string);
            case GREEN_HOUSE:
                return new Greenhouse(measurement, selectedSubAreaShape, title, information, imageLinks, indexOf, string);
            case LAWN:
                return new Lawn(measurement, selectedSubAreaShape, title, information, imageLinks, indexOf, string);
            case PLANT_BED:
                return new PlantBed(measurement, selectedSubAreaShape, title, information, imageLinks, indexOf, string);
            case POND:
                return new Pond(measurement, selectedSubAreaShape, title, information, imageLinks, indexOf, string);
            case RAISED_PLANT_BED:
                return new RaisedPlantBed(measurement, selectedSubAreaShape, title, information, imageLinks, indexOf, string);
            case ROOM:
                return new Room();
            case SINGLE_CONTAINTER:
                return new SingleContainer();
            default:
                throw new IllegalArgumentException("Invalid sub area type.");
        }
    }
}
