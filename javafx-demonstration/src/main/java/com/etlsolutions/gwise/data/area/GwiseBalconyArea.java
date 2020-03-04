package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseBalconyArea extends GwiseArea {

    public GwiseBalconyArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseBalconyArea(GwiseAreaBean dataUnit) {
        super(dataUnit);
    }

    @Override
    public GwiseBalconyAreaBean getBean() {
        return new GwiseBalconyAreaBean(this);
    }

    @Override
    public AreaType getType() {
        return AreaType.BALCONY;
    }
    
    
}
