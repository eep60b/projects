package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.ContainerSetMeasurement;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurement;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.CIRCLE;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.IRREGULAR;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.RECTANGLE;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.SQUARE;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.TRIANGLE;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurement;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.area.subarea.location.ContainterMeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.GroundLocationMeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.log.gvent.FloweringGvent;
import com.etlsolutions.javafx.data.log.gvent.FloweringGventValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.FruitingGvent;
import com.etlsolutions.javafx.data.log.gvent.FruitingGventValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.gwise.data.log.gvent.GventType;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.presentation.dialog.area.AreaValueDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.CircleDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.MeasurementDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.RectangleDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.SquareDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.TriangleDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.BorderMeasurementDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.BoxDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.CirclePondDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.ContainerSetDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.IrregularPondDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.SquarePondDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.TrianglePondDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.location.ContainerDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.location.GroundLocationMeasurementDataModel;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.location.LocationMeasurementDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.FloweringGventDetailDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.FruitingGventDetailDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.GventDetailDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.CustomTaskDetailDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.FertilisationTaskDetailDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.HarvestingTaskDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.PlantThinningTaskDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.PruningTaskDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.TaskDetailDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.TransplantTaskDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.task.WateringTaskDataModel;

/**
 *
 * @author zc
 */
public class DetailDataModelGenerator {

    private static final DetailDataModelGenerator INSTANCE = new DetailDataModelGenerator();

    public static final DetailDataModelGenerator getInstance() {
        return INSTANCE;
    }

    public MeasurementDataModel getMeasurementDataModel(MeasurementType type) {
        switch (type) {
            case CIRCLE:
                return new CircleDataModel(new CircleMeasurement());
            case RECTANGLE:
                return new RectangleDataModel(new RectangleMeasurement());
            case IRREGULAR:
                return new AreaValueDataModel(new IrregularMeasurement());
            case TRIANGLE:
                return new TriangleDataModel(new TriangleMeasurement());
            case SQUARE:
                return new SquareDataModel(new SquareMeasurement());
            default:
                throw new IllegalArgumentException("Invalid measurement type.");
        }
    }

    public MeasurementDataModel getMeasurementDataModel(Measurement measurement) {
        switch (measurement.getType()) {
            case CIRCLE:
                return new CircleDataModel((CircleMeasurement) measurement);
            case RECTANGLE:
                return new RectangleDataModel((RectangleMeasurement) measurement);
            case IRREGULAR:
                return new AreaValueDataModel((IrregularMeasurement) measurement);
            case TRIANGLE:
                return new TriangleDataModel((TriangleMeasurement) measurement);
            case SQUARE:
                return new SquareDataModel((SquareMeasurement) measurement);
            default:
                throw new IllegalArgumentException("Invalid measurement type.");
        }
    }

    public MeasurementDataModel getMeasurementDataModel(SubAreaType type, Measurement measurement) {

        switch (type) {
            case BORDER:
                return new BorderMeasurementDataModel((BorderMeasurement) measurement);
            case CONTAINTER_SET:
                return new ContainerSetDataModel((ContainerSetMeasurement) measurement);
            case CUSTOM:
            case GREEN_HOUSE:
            case PLANT_BED:
            case LAWN:
                return getMeasurementDataModel(measurement);

            case POND:
                return getDepthMeasurementDataModel("Depth", measurement);
            case RAISED_PLANT_BED:
            case ROOM:
                return getDepthMeasurementDataModel("Height", measurement);

            default:
                throw new IllegalArgumentException("Invalid measurement.");
        }

    }

    private MeasurementDataModel getDepthMeasurementDataModel(String title, Measurement measurement) {
        switch (measurement.getType()) {
            case CIRCLE:
                return new CirclePondDataModel(title, (CircleMeasurement) measurement);
            case RECTANGLE:
                return new BoxDataModel(title, (RectangleMeasurement) measurement);
            case SQUARE:
                return new SquarePondDataModel(title, (SquareMeasurement) measurement);
            case TRIANGLE:
                return new TrianglePondDataModel(title, (TriangleMeasurement) measurement);
            case IRREGULAR:
                return new IrregularPondDataModel(title, (IrregularMeasurement) measurement);
            default:
                throw new IllegalArgumentException("Invalid measurement.");
        }
    }

    public final LocationMeasurementDataModel getMeasurementDataModel(LocationMeasurementType type) {
        switch (type) {
            case CONTAINER:
                return new ContainerDataModel(new ContainterMeasurementValueWrapper());
            case GROUND_LOCATION:
                return new GroundLocationMeasurementDataModel(new GroundLocationMeasurementValueWrapper());
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public final GventDetailDataModel getDetailDataModel(GventType type) {
        switch (type) {
            case FLOWERING:
                return new FloweringGventDetailDataModel(LogFactory.getInstance().createDefaultFloweringGventValueWrapper());
            case FRUITING:
                return new FruitingGventDetailDataModel(LogFactory.getInstance().createDefaultFruitingGventValueWrapper());
            default:
                return null;
        }
    }

    public final TaskDetailDataModel getDetailDataModel(TaskType type) {
        switch (type) {
            case CUSTOM:
                return new CustomTaskDetailDataModel(LogFactory.getInstance().getDefaultCustomTaskValueWrapper());
            case FERTILZATION:
                return new FertilisationTaskDetailDataModel(LogFactory.getInstance().getDefaultFertilisationTaskValueWrapper());
            case HARVESTING:
                return new HarvestingTaskDataModel(LogFactory.getInstance().getDefaultHarvestingTaskValueWrapper());
            case PLANT_THINNING:
                return new PlantThinningTaskDataModel(LogFactory.getInstance().getDefaultPlantThinningTaskValueWrapper());
                case PRUNING:
                    return new PruningTaskDataModel(LogFactory.getInstance().getDefaultPruningTaskValueWrapper());
                case TRANSPLANTING:
                    return new TransplantTaskDataModel(LogFactory.getInstance().getDefaultTransplantTasklValueWrapper());
                    case WATERING:
                        return new WateringTaskDataModel(LogFactory.getInstance().getDefaultWateringTaskValueWrapper());
            default:
                return null;
        }
    }

    public GventDetailDataModel getDetailDataModel(Gvent gvent) {

        switch (gvent.getType()) {
            case FLOWERING:
                return new FloweringGventDetailDataModel(new FloweringGventValueWrapper((FloweringGvent) gvent));
            case FRUITING:
                return new FruitingGventDetailDataModel(new FruitingGventValueWrapper((FruitingGvent) gvent));
            default:
                return null;
        }
    }
}
