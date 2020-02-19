package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.basicshape.GwisePointBean;
import com.etlsolutions.gwise.data.basicshape.GwiseShapeBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLocationSetBean extends GwiseDataUnitBean {

    private int parentId;    
    private int plantSetId;
    private GwisePointBean referencePoint;
    private GwiseShapeBean shape;
    private List<GwiseLocationBean> locations = new ArrayList<>();

    public GwiseLocationSetBean() {
    }

    public GwiseLocationSetBean(GwiseLocationSet set) {
        super(set);
        parentId = set.getLocationPlantSet().getId();
        plantSetId = set.getLocationPlantSet().getId();
        referencePoint = new GwisePointBean(set.getReferencePoint());
    }

    public int getPlantSetId() {
        return plantSetId;
    }

    public void setPlantSetId(int plantSetId) {
        this.plantSetId = plantSetId;
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

    public GwiseShapeBean getShape() {
        return shape;
    }

    public void setShape(GwiseShapeBean shape) {
        this.shape = shape;
    }

    public List<GwiseLocationBean> getLocations() {
        return locations;
    }

    public void setLocations(List<GwiseLocationBean> locations) {
        this.locations = locations;
    }
}
