package com.etlsolutions.javafx.data.area;

import com.etlsolutions.gwise.data.area.AreaType;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import static com.etlsolutions.gwise.data.area.AreaType.ALLOTMENT;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.PolygonMeasurementWrapper;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import javafx.collections.ObservableList;
import javafx.scene.shape.PathElement;

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
        AreaValueWrapper areaValueWrapper = new AreaValueWrapper("My Garden", "", new ObservableListWrapperA<ImageLink>(), null, "", 0, 0, GwiseShapeType.RECTANGLE);

        ObservableListWrapperA<SubArea> subAreas = new ObservableListWrapperA<>();
        RectangleMeasurementValueWrapper measurementValueWrapper = new RectangleMeasurementValueWrapper();

        GardenArea gardenArea = new GardenArea(areaValueWrapper, subAreas, measurementValueWrapper);

        gardenArea.getSubAreas().add(plantBed);
        AreaRoot root = new AreaRoot("All Areas");
        root.getAreas().add(gardenArea);

        AreaValueWrapper bedRoomDataUnitValueWrapper = new AreaValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "", 0, 0, GwiseShapeType.RECTANGLE);
        IndoorArea bedRoom = new IndoorArea(bedRoomDataUnitValueWrapper, subAreas, new RectangleMeasurementValueWrapper());

        AreaValueWrapper livingRoomDataUnitValueWrapper = new AreaValueWrapper("Living Room", "", new ObservableListWrapperA<ImageLink>(), null, "", 0, 0, GwiseShapeType.RECTANGLE);
        IndoorArea livingRoom = new IndoorArea(livingRoomDataUnitValueWrapper, subAreas, new RectangleMeasurementValueWrapper());

        AreaValueWrapper kitchenRoomDataUnitValueWrapper = new AreaValueWrapper("Bed Room", "", new ObservableListWrapperA<ImageLink>(), null, "", 0, 0, GwiseShapeType.RECTANGLE);
        IndoorArea kitchen = new IndoorArea(kitchenRoomDataUnitValueWrapper, subAreas, new RectangleMeasurementValueWrapper());

        root.getAreas().addAll(bedRoom, livingRoom, kitchen);
        return root;
    }

    public AreaValueWrapper getDefaultAreaValueWrapper() {
        return new AreaValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", 0, 0, GwiseShapeType.POLYGON);
    }
    
    public Area createArea(AreaType type, AreaValueWrapper areaValueWrapper, MeasurementValueWrapper measurementValueWrapper, ObservableListWrapperA<SubArea> subAreas) {
                
        switch (type) {
            case ALLOTMENT:
                return new AllotmentArea(areaValueWrapper, subAreas, measurementValueWrapper);                
            case BALCONY:
                return new BalconyArea(areaValueWrapper, subAreas, measurementValueWrapper);
            case CUSTOM:
                return new CustomArea(areaValueWrapper, subAreas, measurementValueWrapper);
            case FARM:
                return new FarmArea(areaValueWrapper, subAreas, measurementValueWrapper);
            case GARDEN:
                return new GardenArea(areaValueWrapper, subAreas, measurementValueWrapper);
            case INDOOR:
                return new IndoorArea(areaValueWrapper, subAreas, measurementValueWrapper);
            case PATIO:
                return new PatioArea(areaValueWrapper, subAreas, measurementValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid area type.");
        }
    }

    public Area createTypedArea(AreaType type) {
        return createArea(type, getDefaultAreaValueWrapper(), new PolygonMeasurementWrapper(), new ObservableListWrapperA<SubArea>());
    }

    public Area createPolygonArea(AreaType areaType, ObservableList<Double> points) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Area createRectangleArea(AreaType type, GwiseShapeType areaShape, double x, double y, double width, double height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Area createCircleArea(AreaType type, double centerX, double centerY, double radius) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Area createIrregularArea(AreaType type, ObservableList<PathElement> elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
