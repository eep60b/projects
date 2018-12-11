package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.TypedItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * @author zc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "BorderMeasurement", value = BorderMeasurement.class),
        @JsonSubTypes.Type(name = "CircleMeasurement", value = CircleMeasurement.class),
        @JsonSubTypes.Type(name = "ContainerSetMeasurement", value = ContainerSetMeasurement.class),
        @JsonSubTypes.Type(name = "IrregularMeasurement", value = IrregularMeasurement.class),
        @JsonSubTypes.Type(name = "RectangleMeasurement", value = RectangleMeasurement.class),
        @JsonSubTypes.Type(name = "SquareMeasurement", value = SquareMeasurement.class),
        @JsonSubTypes.Type(name = "TriangleMeasurement", value = TriangleMeasurement.class)
})
public interface Measurement extends TypedItem<MeasurementType>{
    
}
