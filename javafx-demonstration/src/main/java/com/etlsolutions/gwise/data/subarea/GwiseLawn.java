package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.basicshape.GwiseShape;
import com.etlsolutions.gwise.data.basicshape.ShapeUtils;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLawn extends GwiseSubarea {

    private final ValueWrapper<GwiseShape> shapeWrapper;
    
    public GwiseLawn(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, GwiseArea parent, GwisePoint referencePoint,
            GwiseShape shape) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, parent, referencePoint);
        shapeWrapper = new ValueWrapper<>(shape);
    }

    public GwiseLawn(GwiseLawnBean bean) {
        super(bean);
        shapeWrapper = new ValueWrapper<>(ShapeUtils.getInstance().getShape(bean.getShapeBean()));        
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
