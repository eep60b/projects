package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.subarea.location.BorderLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import com.etlsolutions.javafx.data.area.subarea.location.GreenHouseGroundLocation;
import com.etlsolutions.javafx.data.area.subarea.location.PlantBedLocation;
import com.etlsolutions.javafx.data.area.subarea.location.PondLocation;
import java.util.ArrayList;

/**
 *
 * @author zc
 */
public class SubareaFactory {

    public static ContainerSet createContainerSet() {
        ContainerSet s = new ContainerSet();
        s.setId(DataUnitIdRegistry.createNewId());
        s.setTitle("Untitled");
        s.setInformation("");
        s.setImageLinks(new ArrayList<ImageLink>());
        return s;
    }

    public static CustomSubarea createCustomSubarea() {
        CustomSubarea s = new CustomSubarea();
        s.setId(DataUnitIdRegistry.createNewId());
        s.setTitle("Untitled");
        s.setInformation("");
        s.setImageLinks(new ArrayList<ImageLink>());
        return s;
    }

    public static Greenhouse createGreenhouse() {
        Greenhouse g = new Greenhouse();
        g.setId(DataUnitIdRegistry.createNewId());
        g.setTitle("Untitled");
        g.setInformation("");
        g.setImageLinks(new ArrayList<ImageLink>());
        return g;
    }

    public static PlantBed createPlantBed() {
        PlantBed b = new PlantBed();
        b.setId(DataUnitIdRegistry.createNewId());
        b.setTitle("Untitled");
        b.setInformation("");
        b.setShape("Not specified");
        b.setImageLinks(new ArrayList<ImageLink>());
        return b;
    }

    public static Border createPlantBedBorder() {

        Border b = new Border();
        b.setId(DataUnitIdRegistry.createNewId());
        b.setTitle("Untitled");
        b.setInformation("");
        b.setImageLinks(new ArrayList<ImageLink>());
        return b;
    }

    public static Pond createPond() {
        Pond p = new Pond();
        p.setId(DataUnitIdRegistry.createNewId());
        p.setTitle("Untitled");
        p.setInformation("");
        p.setShape("Not specified");
        p.setImageLinks(new ArrayList<ImageLink>());
        return p;
    }

    public static RaisedPlantBed createRaisedPlantBed() {
        RaisedPlantBed r = new RaisedPlantBed();
        r.setId(DataUnitIdRegistry.createNewId());
        r.setTitle("Untitled");
        r.setInformation("");
        r.setShape("Not specified");
        r.setImageLinks(new ArrayList<ImageLink>());
        return r;
    }

    public static Room createRoom() {
        Room r = new Room();
        r.setId(DataUnitIdRegistry.createNewId());
        r.setTitle("Untitled");
        r.setInformation("");
        r.setImageLinks(new ArrayList<ImageLink>());
        r.setContainers(new ArrayList<Container>());
        r.setContainerSets(new ArrayList<ContainerSet>());
        return r;
    }
}
