package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import static com.etlsolutions.javafx.data.area.AreaType.ALLOTMENT;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public final class AreaFactory {

    private static final AreaFactory INSTANCE = new AreaFactory();
    
    public static final AreaFactory getInstance() {
        return INSTANCE;
    }
    
    public AreaRoot createAreaRoot() {

        PlantBed plantBed = (PlantBed) SubAreaFactory.getInstance().createSubArea(SubAreaType.PLANT_BED, "Untitled", "", new ObservableListWrapperA<ImageLink>(),
                0, "", SubAreaShape.RECTANGLE, new SubAreaMeasurement());
        GardenArea gardenArea = createGardenArea("My Garden", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);
        gardenArea.getPlantBeds().add(plantBed);
        AreaRoot a = new AreaRoot("", "");
        a.getGardenAreas().add(gardenArea);

        IndoorArea bedRoom = createIndoorArea("Bed Room", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);
        IndoorArea livingRoom = createIndoorArea("Living Room", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);
        IndoorArea kitchen = createIndoorArea("Kitchen", "", new ObservableListWrapperA<ImageLink>(), 0, "", -300, -300, new AreaMeasurement(), AreaShape.RECTANGLE);

        a.getIndoorAreas().addAll(bedRoom, livingRoom, kitchen);
        return a;
    }

    public AllotmentArea createAllotmentArea(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new AllotmentArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public BalconyArea createBalconyArea(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new BalconyArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public CustomArea createCustomArea(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new CustomArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public FarmArea createFarmArea(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new FarmArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public GardenArea createGardenArea(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new GardenArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public IndoorArea createIndoorArea(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new IndoorArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);

    }

    public PatioArea createPatioArea(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        return new PatioArea(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
    }

    public Area createArea(AreaType type, DataUnitValueWrapper commonValueWrapper, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        switch (type) {
            case ALLOTMENT:
                return createAllotmentArea(commonValueWrapper.getTitleWrapper().getValue(), 
                        commonValueWrapper.getInformationWrapper().getValue(), commonValueWrapper.getImageLinks(), commonValueWrapper.getImageLinks().indexOf(commonValueWrapper.getSelectedImageLinkWrapper().getValue()), 
                        commonValueWrapper.getLogoPathWrapper().getValue(), longitude, latitude, measurement, shape);

            default:
                throw new IllegalArgumentException("Invalid area type.");
        }
    }
}
