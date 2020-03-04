package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePatioArea extends GwiseArea {

    public GwisePatioArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
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
