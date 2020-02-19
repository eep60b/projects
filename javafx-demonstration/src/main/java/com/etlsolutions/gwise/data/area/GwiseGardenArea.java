package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.AreaType;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGardenArea extends GwiseArea {

    public GwiseGardenArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseGardenArea(GwiseGardenAreaBean dataUnit) {
        super(dataUnit);
    }

    
    @Override
    public AreaType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
