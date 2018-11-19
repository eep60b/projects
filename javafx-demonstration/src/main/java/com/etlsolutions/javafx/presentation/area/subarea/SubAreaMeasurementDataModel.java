package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.presentation.area.FxmlMeasurementDataModel;

/**
 *
 * @author zc
 */
public class SubAreaMeasurementDataModel implements FxmlMeasurementDataModel{

    private final Measurement measurement;

    public SubAreaMeasurementDataModel(Measurement measurement) {
        this.measurement = measurement;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    @Override
    public String getFxmlPath(Object object) {
        SubAreaShape shape = (SubAreaShape) object;
        switch (shape) {
            case RECTANGLE:
                return "/fxml/area/LengthWidthFXML.fxml";
            case SQURE:
                return "/fxml/area/SquareFXML.fxml";
            case CIRCLE:
                return "/fxml/area/CircleFXML.fxml";
            case TRIANGLE:
                return "/fxml/area/TriangleFXML.fxml";
            case ROUND_BORDER:
                return "/fxml/area/RoundFXML.fxml";
            case GOTHIC:
                return "/fxml/area/BoxFXML.fxml";
            case HOOP:
                return "/fxml/area/BoxFXML.fxml";
            case DOOM:
                return "/fxml/area/DoomFXML.fxml";
            case LEAN_TO_WALL:
                return "/fxml/area/BoxFXML.fxml";
            case STRAIGHT_LINE_BORDER:
                return "/fxml/area/LengthWidthFXML.fxml";
            case RECTANGLE_POND:
                return "/fxml/area/RectanglePondFXML.fxml";
            case SQUARE_POND:
                return "/fxml/area/SquarePondFXML.fxml";
            case CIRCLE_POND:
                return "/fxml/area/CirclePondFXML.fxml";
            case TRIANGLE_POND:
                return "/fxml/area/TrianglePondFXML.fxml";
            case IRREGULAR:
                return "/fxml/area/AreaValueFXML.fxml";
            case IRREGULAR_POND:
                return "/fxml/area/IrregularPondFXML.fxml";
            default:
                throw new IllegalArgumentException("Invalid shape.");
        }
    }
}
