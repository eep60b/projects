package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.basicshape.GwisePointBean;

/**
 * The Java bean for GwiseLocation which represents the location for a single
 * plant.
 *
 * @author ZhipengChang
 */
public class GwiseLocationBean extends GwiseDataUnitBean {

    private int parentId;
    private int plantId;
    private GwisePointBean referencePoint;
    private boolean autoFilled; //Not sure if this field is need. In the event when the plants are counted, probably it is good to have.

    public GwiseLocationBean() {
    }

    public GwiseLocationBean(GwiseLocation location) {
        super(location);
        parentId = location.getParent().getId();
        plantId = location.getPlant().getId();
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public GwisePointBean getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(GwisePointBean referencePoint) {
        this.referencePoint = referencePoint;
    }

    public boolean isAutoFilled() {
        return autoFilled;
    }

    public void setAutoFilled(boolean autoFilled) {
        this.autoFilled = autoFilled;
    }
}
