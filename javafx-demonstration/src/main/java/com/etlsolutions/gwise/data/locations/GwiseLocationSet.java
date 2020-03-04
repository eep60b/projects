package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.basicshape.GwiseShape;
import com.etlsolutions.gwise.data.basicshape.GwiseShapeBean;
import com.etlsolutions.gwise.data.basicshape.ShapeUtils;
import com.etlsolutions.gwise.data.plant.GwiseLocationPlantSet;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.system.ProjectManager;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLocationSet extends GwiseDataUnit {

    private final GwisePlantSubgroupLocationSet parent;
    private final GwiseLocationPlantSet locationPlantSet;
    private final ValueWrapper<GwisePoint> referencePointWrapper;
    private final ValueWrapper<GwiseShape> shapeWrapper;
    private final ObservableListWrapperA<GwiseLocation> locations;

    public GwiseLocationSet(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            GwisePlantSubgroupLocationSet parent, GwiseLocationPlantSet locationPlantSet, GwisePoint referencePoint,
            GwiseShape shape, List<GwiseLocation> locations) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.parent = parent;
        this.locationPlantSet = locationPlantSet;
        referencePointWrapper = new ValueWrapper<>(referencePoint);
        shapeWrapper = new ValueWrapper<>(shape);
        this.locations = new ObservableListWrapperA<>(locations);
    }

    public GwiseLocationSet(GwiseLocationSetBean bean) {
        super(bean);
        parent = ProjectManager.getInstance().getGwiseItem(bean.getParentId());
        locationPlantSet = ProjectManager.getInstance().getGwiseItem(bean.getPlantSetId());
        referencePointWrapper = new ValueWrapper<>(new GwisePoint(bean.getReferencePoint()));

        GwiseShapeBean shapeBean = bean.getShape();
        shapeWrapper = new ValueWrapper<>(ShapeUtils.getInstance().getShape(shapeBean));
     
        locations = new ObservableListWrapperA<>();
        for (GwiseLocationBean location : bean.getLocations()) {
            locations.add(new GwiseLocation(location));
        }
    }

    @Override
    public GwiseLocationSetBean getBean() {
        return new GwiseLocationSetBean(this);
    }

    public GwisePlantSubgroupLocationSet getParent() {
        return parent;
    }

    public GwiseLocationPlantSet getLocationPlantSet() {
        return locationPlantSet;
    }

    public GwisePoint getReferencePoint() {
        return referencePointWrapper.getValue();
    }

    public void setReferencePoint(GwisePoint point) {
        referencePointWrapper.setValue(point);
    }

    public ValueWrapper<GwisePoint> getReferencePointWrapper() {
        return referencePointWrapper;
    }

    public GwiseShape getShape() {
        return shapeWrapper.getValue();
    }    
    
    public void setShape(GwiseShape shape) {
        shapeWrapper.setValue(shape);
    }
    
    public ValueWrapper<GwiseShape> getShapeWrapper() {
        return shapeWrapper;
    }

    public ObservableListWrapperA<GwiseLocation> getLocations() {
        return locations;
    }
}
