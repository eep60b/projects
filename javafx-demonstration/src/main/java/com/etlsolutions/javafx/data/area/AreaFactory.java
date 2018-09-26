package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import com.etlsolutions.javafx.data.ImageLink;
import java.util.ArrayList;

/**
 *
 * @author zc
 */
public final class AreaFactory {

    public static AreaRoot createAreaRoot() {
        AreaRoot a = new AreaRoot();
        
        GardenArea gardenArea = createGardenArea();
        gardenArea.setTitle("My Garden");
        a.getGardenAreas().add(gardenArea);
        
        IndoorArea bedRoom = createIndoorArea();
        bedRoom.setTitle("Bed Room");
        IndoorArea livingRoom = createIndoorArea();
        livingRoom.setTitle("Living Room");
        IndoorArea kitchen = createIndoorArea();
        kitchen.setTitle("Kitchen");   
        
        a.getIndoorAreas().addAll(bedRoom, livingRoom, kitchen);
        return a;
    }

    public static AllotmentArea createAllotmentArea() {
        AllotmentArea a = new AllotmentArea(10, 5, "meter");
        a.setId(DataUnitIdRegistry.createNewId());
        a.setInformation("");        
        a.setTitle("Untitled");
        a.setImageLinks(new ArrayList<ImageLink>());
        return a;
    }

    public static BalconyArea createBalconyArea() {
        BalconyArea a = new BalconyArea();
        a.setId(DataUnitIdRegistry.createNewId());
        a.setTitle("Untitled");
        a.setImageLinks(new ArrayList<ImageLink>());       
        return a;
    }

    public static CustomArea createCustomArea() {
        CustomArea a = new CustomArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setImageLinks(new ArrayList<ImageLink>());
        return a;
    }

    public static FarmArea createFarmArea() {
        FarmArea a = new FarmArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImageLinks(new ArrayList<ImageLink>());
        return a;
    }
    
    public static GardenArea createGardenArea() {
        GardenArea a = new GardenArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImageLinks(new ArrayList<ImageLink>());
        return a;
    } 
    
    public static IndoorArea createIndoorArea() {
        IndoorArea a = new IndoorArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImageLinks(new ArrayList<ImageLink>());      
        return a;
    }
    
    public static PatioArea createPatioArea() {
        PatioArea a = new PatioArea();
        a.setId(DataUnitIdRegistry.createNewId());        
        a.setTitle("Untitled");
        a.setInformation("");        
        a.setImageLinks(new ArrayList<ImageLink>());     
        return a;
    }     
}
