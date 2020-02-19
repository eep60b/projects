package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.AreaType;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public abstract class GwiseArea extends GwiseDataUnit {

    public GwiseArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseArea(GwiseAreaBean dataUnit) {
        super(dataUnit);
    }
    
    public abstract AreaType getType();
}
