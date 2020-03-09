package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePatioArea extends GwiseArea {

    public GwisePatioArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, AreaType type, List<GwiseSubarea> subareas) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, type, subareas);
    }



    public GwisePatioArea(GwisePatioAreaBean dataUnit) {
        super(dataUnit);
    }

    @Override
    public AreaType getType() {
        return AreaType.PATIO;
    }

    @Override
    public GwisePatioAreaBean getBean() {
        return new GwisePatioAreaBean(this);
    }
    
}
