package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.basicshape.GwiseLineShape;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.basicshape.ShapeUtils;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ValueWrapper;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseBorder extends GwiseSubarea {
   
    private final ValueWrapper<GwiseLineShape> shapeWrapper;    
    
    public GwiseBorder(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, GwiseArea parent,
            GwisePoint referecePoint, GwiseLineShape shape) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, parent, referecePoint);
        shapeWrapper = new ValueWrapper<>(shape);
    }

    public GwiseBorder(GwiseBorderBean bean) {
        super(bean);
        shapeWrapper = new ValueWrapper<>(ShapeUtils.getInstance().getShape(bean.getShape()));
    }

    @Override
    public GwiseBorderBean getBean() {
        return new GwiseBorderBean(this);
    }

    public GwiseLineShape getShape() {
        return shapeWrapper.getValue();
    }     
    
    public void setShape(GwiseLineShape shape) {
        shapeWrapper.setValue(shape);
    }
    
    public ValueWrapper<GwiseLineShape> getShapeWrapper() {
        return shapeWrapper;
    } 
}
