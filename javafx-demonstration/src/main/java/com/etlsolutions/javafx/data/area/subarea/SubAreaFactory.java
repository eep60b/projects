package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.ContainerSetMeasurement;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.Container;

/**
 *
 * @author zc
 */
public class SubAreaFactory {

    private static final SubAreaFactory INSTANCE = new SubAreaFactory();

    public static final SubAreaFactory getInstance() {
        return INSTANCE;
    }
    
    public PlantBed createDefaultPlantBed() {
        
        DataUnitValueWrapper dataUnitValueWrapper = new DataUnitValueWrapper("Untitled plant bed", "", new ObservableListWrapperA<ImageLink>(), null, "");
        return new PlantBed(new RectangleMeasurement(), dataUnitValueWrapper);
    }

    public SubArea createSubArea(SubAreaType selectedSubAreaType, DataUnitValueWrapper commonValueWrapper, Measurement measurement, Container... containers) {

        switch (selectedSubAreaType) {
            case BORDER:
                return new Border((BorderMeasurement)measurement, commonValueWrapper);
            case CONTAINTER_SET:
                return new ContainerSet(containers[0], (ContainerSetMeasurement)measurement, commonValueWrapper);
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
                return new SingleContainer(containers[0], commonValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid sub area type.");
        }
    }

    public SubAreaValueWrapper getDefaultSubAreaValueWrapper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
