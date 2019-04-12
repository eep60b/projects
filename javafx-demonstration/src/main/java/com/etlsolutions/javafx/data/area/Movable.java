package com.etlsolutions.javafx.data.area;

/**
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
