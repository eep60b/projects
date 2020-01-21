package com.etlsolutions.javafx.data.area;

/**
 * The Movable interface defines an object which can be moved from place to
 * place on the ground or on another Movable object.
 *
 * Not sure if this interface is useful.
 *
 * @author zc
 */
public interface Movable {

    double getCenterX();

    double getCenterY();

    void setCenterX(double centerX);

    void setCenterY(double centerY);

    double getOcuppiedWidth();

    void setOcuppiedWidth(double ocuppiedWidth);

    double getOccuppiedHeight();

    void setOccuppiedHeight(double occuppiedHeight);

}
