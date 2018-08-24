package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubarea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.PlantBedBorder;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import java.util.ArrayList;

/**
 *
 * @author zc
 */
public final class AreaFactory {

    public static AreaRoot createAreaRoot() {
        AreaRoot a = new AreaRoot();
        a.setAllotmentAreas(new ArrayList<AllotmentArea>());
        a.setBalconyAreas(new ArrayList<BalconyArea>());
        a.setCustomAreas(new ArrayList<CustomArea>());
        a.setGardenAreas(new ArrayList<GardenArea>());
        a.setIndoorAreas(new ArrayList<IndoorArea>());
        a.setFarmAreas(new ArrayList<FarmArea>());
        a.setPatioAreas(new ArrayList<PatioArea>());
        return a;
    }

    public static AllotmentArea createAllotmentArea() {
        AllotmentArea a = new AllotmentArea(10, 5, "meter", new ArrayList<PlantBed>(), new ArrayList<RaisedPlantBed>(), new ArrayList<PlantBedBorder>(),
                new ArrayList<Greenhouse>(), new ArrayList<CustomSubarea>());
        a.setId(DataUnitIdRegistry.createNewId());
        a.setInformation("");        
        a.setTitle("Untitled");
        a.setImgLinks(new ArrayList<ImageLink>());
        return a;
    }

    public static BalconyArea createBalconyArea() {
        BalconyArea a = new BalconyArea();
        a.setId(DataUnitIdRegistry.createNewId());
        a.setTitle("Untitled");
        a.setImgLinks(new ArrayList<ImageLink>());
        a.setContainers(new ArrayList<Container>());
        a.setContainerSets(new ArrayList<ContainerSet>());        
        return a;
    }

    public static CustomArea createCustomArea() {
        CustomArea a = new CustomArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setImgLinks(new ArrayList<ImageLink>());
        a.setCustomSubareas(new ArrayList<CustomSubarea>());
        return a;
    }

    public static FarmArea createFarmArea() {
        FarmArea a = new FarmArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImgLinks(new ArrayList<ImageLink>());
        a.setPlantBeds(new ArrayList<PlantBed>());
        a.setCustomSubareas(new ArrayList<CustomSubarea>());
        a.setBorders(new ArrayList<PlantBedBorder>());
        return a;
    }
    
    public static GardenArea createGardenArea() {
        GardenArea a = new GardenArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImgLinks(new ArrayList<ImageLink>());
        a.setPlantBeds(new ArrayList<PlantBed>());
        a.setSubareas(new ArrayList<CustomSubarea>());
        a.setBorders(new ArrayList<PlantBedBorder>());
        a.setContainers(new ArrayList<Container>());
        a.setContainerSets(new ArrayList<ContainerSet>());
        a.setRaisedPlantBeds(new ArrayList<RaisedPlantBed>());
        return a;
    } 
    
    public static IndoorArea createIndoorArea() {
        IndoorArea a = new IndoorArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImgLinks(new ArrayList<ImageLink>());
        a.setContainers(new ArrayList<Container>());
        a.setContainerSets(new ArrayList<ContainerSet>());        
        return a;
    }
    
    public static PatioArea createPatioArea() {
        PatioArea a = new PatioArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImgLinks(new ArrayList<ImageLink>());
        a.setContainers(new ArrayList<Container>());
        a.setRaisedPlantBeds(new ArrayList<RaisedPlantBed>());
        a.setContainerSets(new ArrayList<ContainerSet>());        
        return a;
    }     
}
