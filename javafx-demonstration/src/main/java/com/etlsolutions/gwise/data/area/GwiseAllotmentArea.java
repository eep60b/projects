package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseAllotmentArea extends GwiseArea {

    public GwiseAllotmentArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, AreaType type, List<GwiseSubarea> subareas) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, type, subareas);
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
        return new GwiseAllotmentAreaBean(this);
    }    
}
