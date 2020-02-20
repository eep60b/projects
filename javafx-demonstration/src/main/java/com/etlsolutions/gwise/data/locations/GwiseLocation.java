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
public class GwiseLocation extends GwiseDataUnit {

    private final GwiseLocationSet parent;        //The parent will not change.
    private final GwisePlant plant;
    private final ValueWrapper<GwisePoint> referencePointWrapper;      
    private final ValueWrapper<Boolean> autoFilledWrapper; //This field is need. In the event when the plants are counted and in the event when a plant is moved from automatically generated position.
        
    public GwiseLocation(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            GwiseLocationSet parent, GwisePlant plant, GwisePoint referencePoint, boolean autoFilled) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.parent = parent;
        this.plant = plant;
        referencePointWrapper = new ValueWrapper<>(referencePoint);
        autoFilledWrapper = new ValueWrapper<>(autoFilled);
    }

    public GwiseLocation(GwiseLocationBean bean) {
        super(bean);
        parent = ProjectManager.getInstance().getGwiseItem(bean.getParentId());
        plant = ProjectManager.getInstance().getGwiseItem(bean.getPlantId());
        referencePointWrapper = new ValueWrapper<>(new GwisePoint(bean.getReferencePoint()));
        autoFilledWrapper = new ValueWrapper<>(bean.isAutoFilled());        
    }

    @Override
    public GwiseLocationBean getBean() {
        return new GwiseLocationBean(this);
    }

    public GwiseLocationSet getParent() {
        return parent;
    }

    public GwisePlant getPlant() {
        return plant;
    }

    public ValueWrapper<GwisePoint> getReferencePointWrapper() {
        return referencePointWrapper;
    }

    public ValueWrapper<Boolean> getAutoFilledWrapper() {
        return autoFilledWrapper;
    }
}
