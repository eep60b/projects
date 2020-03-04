package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseIndoorArea extends GwiseArea {

    public GwiseIndoorArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseIndoorArea(GwiseAreaBean dataUnit) {
        super(dataUnit);
    }

    @Override
    public AreaType getType() {
        return AreaType.INDOOR;
    }

    @Override
    public GwiseIndoorAreaBean getBean() {
        return new GwiseIndoorAreaBean(this);
    }
    
}
