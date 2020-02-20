package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.plant.GwisePlant;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseContainer extends GwiseDataUnit {

    private final GwiseContainerSet parent;
    private final ValueWrapper<GwisePlant> plantWrapper;
    private final ValueWrapper<Double> widthWrapper;
    /**
     *
     * The length is now wrapped by a value wrapper since it will always change
     * with width. The outside world listens to the width change will be enough.
     */
    private Double length;
    private final ValueWrapper<Double> heightWrapper;
    private final ValueWrapper<GwiseContainerShapeType> typeWrapper;
    private final ValueWrapper<GwisePoint> referencePointWrapper;

    public GwiseContainer(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            GwiseContainerSet parent, GwisePlant plant, double width, double length, double height,
            GwiseContainerShapeType type, GwisePoint referencePoint) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.parent = parent;
        plantWrapper = new ValueWrapper<>(plant);
        widthWrapper = new ValueWrapper<>(width);
        this.length = length;
        heightWrapper = new ValueWrapper<>(height);
        typeWrapper = new ValueWrapper<>(type);
        referencePointWrapper = new ValueWrapper<>(referencePoint);
    }

    public GwiseContainer(GwiseContainerBean bean) {
        super(bean);
        parent = ProjectManager.getInstance().getGwiseItem(bean.getParentId());
        GwisePlant plant = ProjectManager.getInstance().getGwiseItem(bean.getPlantId());
        plantWrapper = new ValueWrapper<>(plant);
        widthWrapper = new ValueWrapper<>(bean.getWidth());
        length = bean.getLength();
        heightWrapper = new ValueWrapper<>(bean.getHeight());
        typeWrapper = new ValueWrapper<>(bean.getShapeType());
        referencePointWrapper = new ValueWrapper<>(new GwisePoint(bean.getReferencePoint()));
    }

    @Override
    public GwiseContainerBean getBean() {
        return new GwiseContainerBean(this);
    }

    public GwiseContainerSet getParent() {
        return parent;
    }

    public GwisePlant getPlant() {
        return plantWrapper.getValue();
    }
    
    public void setPlant(GwisePlant plant) {
        plantWrapper.setValue(plant);
    }
    
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public ValueWrapper<GwisePlant> getPlantWrapper() {
        return plantWrapper;
    }

    public ValueWrapper<Double> getWidthWrapper() {
        return widthWrapper;
    }

    public ValueWrapper<Double> getHeightWrapper() {
        return heightWrapper;
    }

    public ValueWrapper<GwiseContainerShapeType> getShapeTypeWrapper() {
        return typeWrapper;
    }

    public ValueWrapper<GwisePoint> getReferencePointWrapper() {
        return referencePointWrapper;
    }

}
