package com.etlsolutions.javafx.data.area.subarea;

/**
 *
 * @author zc
 */
public class SubareaFactory {

    public static ContainerSet createContainerSet() {
        ContainerSet s = new ContainerSet();
        return s;
    }

    public static CustomSubarea createCustomSubarea() {
        CustomSubarea s = new CustomSubarea();

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

    public static PlantBedBorder createPlantBedBorder() {

        PlantBedBorder b = new PlantBedBorder();

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
}