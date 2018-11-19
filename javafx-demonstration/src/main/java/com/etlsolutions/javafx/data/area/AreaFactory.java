package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import static com.etlsolutions.javafx.data.area.AreaType.ALLOTMENT;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
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
        AreaValueWrapper areaValueWrapper = new AreaValueWrapper(0, 0, AreaShape.RECTANGLE);

        GardenAreaValueWrapper gardenAreaValueWrapper = new GardenAreaValueWrapper();
        RectangleMeasurementValueWrapper measurementValueWrapper = new RectangleMeasurementValueWrapper(0, 0, 0);

        GardenArea gardenArea = new GardenArea(gardenAreaDataUnitValueWrapper, areaValueWrapper, gardenAreaValueWrapper, measurementValueWrapper);

        gardenArea.getPlantBeds().add(plantBed);
        AreaRoot a = new AreaRoot("", "");
        a.getGardenAreas().add(gardenArea);

        DataUnitValueWrapper bedRoomDataUnitValueWrapper = new DataUnitValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea bedRoom = new IndoorArea(bedRoomDataUnitValueWrapper, new AreaValueWrapper(0, 0, AreaShape.RECTANGLE), new IndoorAreaValueWrapper(), new RectangleMeasurementValueWrapper(0, 0, 0));

        DataUnitValueWrapper livingRoomDataUnitValueWrapper = new DataUnitValueWrapper("Living Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea livingRoom = new IndoorArea(livingRoomDataUnitValueWrapper, new AreaValueWrapper(0, 0, AreaShape.RECTANGLE), new IndoorAreaValueWrapper(), new RectangleMeasurementValueWrapper(0, 0, 0));

        DataUnitValueWrapper kitchenRoomDataUnitValueWrapper = new DataUnitValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "");
        IndoorArea kitchen = new IndoorArea(kitchenRoomDataUnitValueWrapper, new AreaValueWrapper(0, 0, AreaShape.RECTANGLE), new IndoorAreaValueWrapper(), new RectangleMeasurementValueWrapper(0, 0, 0));

        a.getIndoorAreas().addAll(bedRoom, livingRoom, kitchen);
        return a;
    }

    public Area createArea(AreaType type, DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, AreaSpecialValueWrapper specialValueWrapper, MeasurementValueWrapper measurementValueWrapper) {
        switch (type) {
            case ALLOTMENT:
                return new AllotmentArea(valueWrapper, areaValueWrapper, (AllotmentAreaValueWrapper) specialValueWrapper, measurementValueWrapper);

            default:
                throw new IllegalArgumentException("Invalid area type.");
        }
    }
}
