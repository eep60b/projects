package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public final class AreaFactory {

    public static AreaRoot createAreaRoot() {

        AreaRoot a = new AreaRoot("", "");
        
        GardenArea gardenArea = createGardenArea("My Garden", "");
        a.getGardenAreas().add(gardenArea);
        
        IndoorArea bedRoom = createIndoorArea("Bed Room", "");
        IndoorArea livingRoom = createIndoorArea("Living Room", "");
        IndoorArea kitchen = createIndoorArea("Kitchen", "");
        
        a.getIndoorAreas().addAll(bedRoom, livingRoom, kitchen);
        return a;
    }

    public static AllotmentArea createAllotmentArea(String title, String information, int length, int width, String uom) {
        return new AllotmentArea(title, information, length, width, uom);
    }

    public static BalconyArea createBalconyArea(String title, String information) {
        return new BalconyArea(title, information);
    }

    public static CustomArea createCustomArea(String title, String information) {
        return new CustomArea(title, information);
    }

    public static FarmArea createFarmArea(String title, String information) {
        return new FarmArea(title, information);
    }
    
    public static GardenArea createGardenArea(String title, String information) {
        return new GardenArea(title, information);
    } 
    
    public static IndoorArea createIndoorArea(String title, String information) {
        return new IndoorArea(title, information);

    }
    
    public static PatioArea createPatioArea(String title, String information) {
        return new PatioArea(title, information);
    }     

    public static Area createArea(AreaType type, String title, String information, ObservableList<ImageLink> imageLinks) {
        switch(type) {
            case ALLOTMENT: return AreaFactory.createAllotmentArea(title, information, 0, 0, title);
            default:  throw new IllegalArgumentException("Invalid area type.");
        }
    }
}
