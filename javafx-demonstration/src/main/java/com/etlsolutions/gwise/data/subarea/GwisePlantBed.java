package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantBed extends GwiseSubarea {

    public GwisePlantBed(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, GwiseArea parent, GwisePoint referencePoint) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, parent, referencePoint);
    }

    public GwisePlantBed(GwiseSubareaBean bean) {
        super(bean);
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
