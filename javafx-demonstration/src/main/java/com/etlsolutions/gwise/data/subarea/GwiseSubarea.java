package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.locations.GwiseLocationSet;
import com.etlsolutions.gwise.system.ProjectManager;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseSubarea extends GwiseDataUnit {

    private final GwiseArea parent;
    private final ValueWrapper<GwisePoint> referencePointWrapper;
    protected final ObservableListWrapperA<GwiseLocationSet> locationSets = new ObservableListWrapperA<>();
    
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

    public ObservableListWrapperA<GwiseLocationSet> getLocationSets() {
        return locationSets;
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
