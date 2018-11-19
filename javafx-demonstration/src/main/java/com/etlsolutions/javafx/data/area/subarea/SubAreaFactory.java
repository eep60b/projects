package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;

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

    public PlantBed createDefaultPlantBed() {
        DataUnitValueWrapper dataUnitValueWrapper = new DataUnitValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "");
        
        PlantBed b = new PlantBed(new RectangleMeasurement(), dataUnitValueWrapper);
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

    public SubArea createSubArea(SubAreaType selectedSubAreaType, DataUnitValueWrapper commonValueWrapper, SubAreaValueWrapper subAreaValueWrapper, SubAreaShape selectedSubAreaShape, Measurement measurement) {

        switch (selectedSubAreaType) {
            case BORDER:
                return new Border((BorderMeasurement)measurement, commonValueWrapper);
            case CONTAINTER_SET:
                return new ContainerSet(((ContainerSetValueWrapper)subAreaValueWrapper).getContainerValueWrapper().getValue(), measurement, commonValueWrapper);
            case CUSTOM:
                return new CustomSubArea(measurement, commonValueWrapper);
            case GREEN_HOUSE:
                return new Greenhouse(measurement, commonValueWrapper);
            case LAWN:
                return new Lawn(measurement, commonValueWrapper);
            case PLANT_BED:
                return new PlantBed(measurement, commonValueWrapper);
            case POND:
                return new Pond(measurement, commonValueWrapper);
            case RAISED_PLANT_BED:
                return new RaisedPlantBed(measurement, commonValueWrapper);
            case ROOM:
                return new Room(measurement, commonValueWrapper);
            case SINGLE_CONTAINTER:
                return new SingleContainer(((SingleContainerValueWrapper)subAreaValueWrapper).getContainerValueWrapper().getValue(), commonValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid sub area type.");
        }
    }
}
