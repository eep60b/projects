package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import static com.etlsolutions.javafx.data.area.AreaType.ALLOTMENT;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public final class AreaFactory {

    public static AreaRoot createAreaRoot() {

        AreaRoot a = new AreaRoot("", "");
        
        GardenArea gardenArea = createGardenArea("My Garden", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new RectAngleAreaMeasurement());
        a.getGardenAreas().add(gardenArea);
        
        IndoorArea bedRoom = createIndoorArea("Bed Room", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new RectAngleAreaMeasurement());
        IndoorArea livingRoom = createIndoorArea("Living Room", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new RectAngleAreaMeasurement());
        IndoorArea kitchen = createIndoorArea("Kitchen", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new RectAngleAreaMeasurement());
        
        a.getIndoorAreas().addAll(bedRoom, livingRoom, kitchen);
        return a;
    }

    public static AllotmentArea createAllotmentArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        return new AllotmentArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
    }

    public static BalconyArea createBalconyArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        return new BalconyArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
    }

    public static CustomArea createCustomArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        return new CustomArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
    }

    public static FarmArea createFarmArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        return new FarmArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
    }
    
    public static GardenArea createGardenArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        return new GardenArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
    } 
    
    public static IndoorArea createIndoorArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        return new IndoorArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);

    }
    
    public static PatioArea createPatioArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        return new PatioArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
    }     

    public static Area createArea(AreaType type, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        switch(type) {
            case ALLOTMENT: return createAllotmentArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
            
            default:  throw new IllegalArgumentException("Invalid area type.");
        }
    }
}
