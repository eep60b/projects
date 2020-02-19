package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.basicshape.GwisePointBean;

/**
 *
 * @author ZhipengChang
 */
public class GwiseContainerBean extends GwiseDataUnitBean {

    private int parentId;
    private int plantId;
    private double width;
    private double length;
    private double height;    
    private GwiseContainerShapeType shapeType;
    private GwisePointBean referencePoint;
    
    public GwiseContainerBean() {
    }

    public GwiseContainerBean(GwiseContainer container) {
        super(container);
        parentId = container.getParent().getId();
        plantId = container.getPlant().getId();
        width = container.getWidthWrapper().getValue();
        length = container.getLength();
        height = container.getHeightWrapper().getValue();
        shapeType = container.getShapeTypeWrapper().getValue();
        referencePoint = new GwisePointBean(container.getReferencePointWrapper().getValue());
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public GwiseContainerShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(GwiseContainerShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public GwisePointBean getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(GwisePointBean referencePoint) {
        this.referencePoint = referencePoint;
    }
}
