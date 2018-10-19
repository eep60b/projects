package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import javafx.collections.ObservableList;

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

    public SubArea createSubArea(SubAreaType selectedSubAreaType, String title, String information, ObservableList<ImageLink> imageLinks, int indexOf, String string, SubAreaShape selectedSubAreaShape, SubAreaMeasurement measurement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
