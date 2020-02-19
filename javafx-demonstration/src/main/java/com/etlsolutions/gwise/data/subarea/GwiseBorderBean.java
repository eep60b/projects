package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.basicshape.GwiseLineShapeBean;
import com.etlsolutions.gwise.data.basicshape.GwisePointBean;

/**
 *
 * @author ZhipengChang
 */
public class GwiseBorderBean extends GwiseSubareaBean {

    private GwisePointBean referecePoint;    
    private GwiseLineShapeBean shape;


    public GwiseBorderBean() {
    }

    public GwiseBorderBean(GwiseBorder border) {
        super(border);
    }

    public GwisePointBean getReferecePoint() {
        return referecePoint;
    }

    public void setReferecePoint(GwisePointBean referecePoint) {
        this.referecePoint = referecePoint;
    }

    public GwiseLineShapeBean getShape() {
        return shape;
    }

    public void setShape(GwiseLineShapeBean shape) {
        this.shape = shape;
    } 
}
