package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public abstract class GwiseSubarea extends GwiseDataUnit {

    private final GwiseArea parent;
    private final ValueWrapper<GwisePoint> referencePointWrapper;
    
    public GwiseSubarea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            GwiseArea parent, GwisePoint referencePoint) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.parent = parent;
        referencePointWrapper = new ValueWrapper<>(referencePoint);
    }

    public GwiseSubarea(GwiseSubareaBean bean) {
        super(bean);
        parent = ProjectManager.getInstance().getGwiseItem(bean.getParentId());
        referencePointWrapper = new ValueWrapper<>(new GwisePoint(bean.getReferencePoint()));        
    }

    public GwiseArea getParent() {
        return parent;
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

}
