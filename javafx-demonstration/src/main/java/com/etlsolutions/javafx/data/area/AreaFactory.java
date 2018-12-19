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

        ObservableListWrapperA<SubArea> subAreas = new ObservableListWrapperA<>();
        RectangleMeasurementValueWrapper measurementValueWrapper = new RectangleMeasurementValueWrapper();

        GardenArea gardenArea = new GardenArea(gardenAreaDataUnitValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);

        gardenArea.getSubAreas().add(plantBed);
        AreaRoot root = new AreaRoot("All Areas", "");
        root.getAreas().add(gardenArea);

        DataUnitValueWrapper bedRoomDataUnitValueWrapper = new DataUnitValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea bedRoom = new IndoorArea(bedRoomDataUnitValueWrapper, new AreaValueWrapper(), subAreas, new RectangleMeasurementValueWrapper());

        DataUnitValueWrapper livingRoomDataUnitValueWrapper = new DataUnitValueWrapper("Living Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea livingRoom = new IndoorArea(livingRoomDataUnitValueWrapper, new AreaValueWrapper(), subAreas, new RectangleMeasurementValueWrapper());

        DataUnitValueWrapper kitchenRoomDataUnitValueWrapper = new DataUnitValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea kitchen = new IndoorArea(kitchenRoomDataUnitValueWrapper, new AreaValueWrapper(), subAreas, new RectangleMeasurementValueWrapper());

        root.getAreas().addAll(bedRoom, livingRoom, kitchen);
        return root;
    }

    public Area createArea(AreaType type, DataUnitValueWrapper commonValueWrapper, AreaValueWrapper areaValueWrapper, MeasurementValueWrapper measurementValueWrapper, ObservableListWrapperA<SubArea> subAreas) {
        
        SubAreaListValueWrapper salvw = new SubAreaListValueWrapper(subAreas);
        
        switch (type) {
            case ALLOTMENT:
                return new AllotmentArea(commonValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);                
            case BALCONY:
                return new BalconyArea(commonValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);
            case CUSTOM:
                return new CustomArea(commonValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);
            case FARM:
                return new FarmArea(commonValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);
            case GARDEN:
                return new GardenArea(commonValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);
            case INDOOR:
                return new IndoorArea(commonValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);
            case PATIO:
                return new PatioArea(commonValueWrapper, areaValueWrapper, subAreas, measurementValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid area type.");
        }
    }
}
