package com.etlsolutions.gwise.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLineBean {
    
    private GwisePointBean startPoint;
    private GwisePointBean endPoint;

    public GwiseLineBean() {
    }

    public GwiseLineBean(GwisePointBean startPoint, GwisePointBean endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public GwisePointBean getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(GwisePointBean startPoint) {
        this.startPoint = startPoint;
    }

    public GwisePointBean getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(GwisePointBean endPoint) {
        this.endPoint = endPoint;
    }
}
