package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.javafx.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantBed extends GwiseDataUnit {

    public GwisePlantBed(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwisePlantBed(GwiseDataUnitBean bean) {
        super(bean);
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
