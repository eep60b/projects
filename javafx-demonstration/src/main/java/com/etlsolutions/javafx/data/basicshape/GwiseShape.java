package com.etlsolutions.javafx.data.basicshape;

/**
 * The GwiseShape interface define a geometric object.
 *
 * @author ZhipengChang
 */
public interface GwiseShape {

    /**
     * Get the area of this geometric shape.
     *
     * @return the area in the unit of centimeters X centimeters.
     */
    double area();

    /**
     * Get the perimeter of this geometric shape.
     *
     * @return the perimeter in the unit of centimeter.
     */
    double perimeter();

}
