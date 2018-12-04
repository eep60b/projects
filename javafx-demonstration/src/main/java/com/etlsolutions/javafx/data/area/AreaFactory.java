package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import static com.etlsolutions.javafx.data.area.AreaType.ALLOTMENT;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;

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

        PlantBed plantBed = SubAreaFactory.getInstance().createDefaultPlantBed();
        DataUnitValueWrapper gardenAreaDataUnitValueWrapper = new DataUnitValueWrapper("My Garden", "", new ObservableListWrapperA<ImageLink>(), null, "");
        AreaValueWrapper areaValueWrapper = new AreaValueWrapper();

        SubAreaListValueWrapper subAreas = new SubAreaListValueWrapper();
        RectangleMeasurementValueWrapper measurementValueWrapper = new RectangleMeasurementValueWrapper();

        GardenArea gardenArea = new GardenArea(gardenAreaDataUnitValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);

        gardenArea.getPlantBeds().add(plantBed);
        AreaRoot a = new AreaRoot("", "");
        a.getGardenAreas().add(gardenArea);

        DataUnitValueWrapper bedRoomDataUnitValueWrapper = new DataUnitValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea bedRoom = new IndoorArea(bedRoomDataUnitValueWrapper, new AreaValueWrapper(), subAreas, new RectangleMeasurementValueWrapper());

        DataUnitValueWrapper livingRoomDataUnitValueWrapper = new DataUnitValueWrapper("Living Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea livingRoom = new IndoorArea(livingRoomDataUnitValueWrapper, new AreaValueWrapper(), subAreas, new RectangleMeasurementValueWrapper());

        DataUnitValueWrapper kitchenRoomDataUnitValueWrapper = new DataUnitValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea kitchen = new IndoorArea(kitchenRoomDataUnitValueWrapper, new AreaValueWrapper(), subAreas, new RectangleMeasurementValueWrapper());

        a.getIndoorAreas().addAll(bedRoom, livingRoom, kitchen);
        return a;
    }

    public Area createArea(AreaType type, DataUnitValueWrapper commonValueWrapper, AreaValueWrapper areaValueWrapper, MeasurementValueWrapper measurementValueWrapper, ObservableListWrapperA<SubArea> subAreas) {
        
        SubAreaListValueWrapper salvw = new SubAreaListValueWrapper(subAreas);
        
        switch (type) {
            case ALLOTMENT:
                return new AllotmentArea(commonValueWrapper, areaValueWrapper, salvw, measurementValueWrapper);                
            case BALCONY:
                return new BalconyArea(commonValueWrapper, areaValueWrapper, salvw, measurementValueWrapper);
            case CUSTOM:
                return new CustomArea(commonValueWrapper, areaValueWrapper, salvw, measurementValueWrapper);
            case FARM:
                return new FarmArea(commonValueWrapper, areaValueWrapper, salvw, measurementValueWrapper);
            case GARDEN:
                return new GardenArea(commonValueWrapper, areaValueWrapper, salvw, measurementValueWrapper);
            case INDOOR:
                return new IndoorArea(commonValueWrapper, areaValueWrapper, salvw, measurementValueWrapper);
            case PATIO:
                return new PatioArea(commonValueWrapper, areaValueWrapper, salvw, measurementValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid area type.");
        }
    }
}
