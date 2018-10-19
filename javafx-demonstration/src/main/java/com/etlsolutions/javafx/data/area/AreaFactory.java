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

        GardenArea gardenArea = createGardenArea("My Garden", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);
        a.getGardenAreas().add(gardenArea);

        IndoorArea bedRoom = createIndoorArea("Bed Room", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);
        IndoorArea livingRoom = createIndoorArea("Living Room", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);
        IndoorArea kitchen = createIndoorArea("Kitchen", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);

        a.getIndoorAreas().addAll(bedRoom, livingRoom, kitchen);
        return a;
    }

    public static AllotmentArea createAllotmentArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new AllotmentArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public static BalconyArea createBalconyArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new BalconyArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public static CustomArea createCustomArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new CustomArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public static FarmArea createFarmArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new FarmArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public static GardenArea createGardenArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new GardenArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public static IndoorArea createIndoorArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new IndoorArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);

    }

    public static PatioArea createPatioArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new PatioArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public static Area createArea(AreaType type, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        switch (type) {
            case ALLOTMENT:
                return createAllotmentArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);

            default:
                throw new IllegalArgumentException("Invalid area type.");
        }
    }
}
