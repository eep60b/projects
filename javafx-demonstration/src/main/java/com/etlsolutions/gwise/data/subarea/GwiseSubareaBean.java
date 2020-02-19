package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.basicshape.GwisePointBean;

/**
 *
 * @author ZhipengChang
 */
public class GwiseSubareaBean extends GwiseDataUnitBean {

    private int parentId;
    private GwisePointBean referencePoint;
    
    public GwiseSubareaBean() {
    }

    public GwiseSubareaBean(GwiseSubarea subarea) {
        super(subarea);
        parentId = subarea.getParent().getId();
        referencePoint = new GwisePointBean(subarea.getReferencePoint());
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public GwisePointBean getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(GwisePointBean referencePoint) {
        this.referencePoint = referencePoint;
    }
}
