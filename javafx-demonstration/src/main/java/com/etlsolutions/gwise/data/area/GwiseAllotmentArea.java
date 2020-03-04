package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseAllotmentArea extends GwiseArea {

    
    public GwiseAllotmentArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseAllotmentArea(GwiseAllotmentAreaBean bean) {
        super(bean);
    }
   
    @Override
    public AreaType getType() {
        return AreaType.ALLOTMENT;
    }

    @Override
    public GwiseAllotmentAreaBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
