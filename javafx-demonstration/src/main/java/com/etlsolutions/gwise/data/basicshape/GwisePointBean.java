package com.etlsolutions.gwise.data.basicshape;

/**
 * The GwisePointBean class represents a single point in the area.
 *
 * @author ZhipengChang
 */
public class GwisePointBean {

    private double x;
    private double y;
 
    public GwisePointBean() {
    }

    public GwisePointBean(GwisePoint bean) {
        this.x = bean.getX();
        this.y = bean.getY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }    
}
