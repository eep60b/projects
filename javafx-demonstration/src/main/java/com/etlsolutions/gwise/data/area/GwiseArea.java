package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public abstract class GwiseArea extends GwiseDataUnit {

    protected final ObservableListWrapperA<GwiseSubarea> subareas = new ObservableListWrapperA<>();
    
    public GwiseArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseArea(GwiseAreaBean dataUnit) {
        super(dataUnit);
    }
    
    public abstract AreaType getType();

    public final ObservableListWrapperA<GwiseSubarea> getSubareas() {
        return subareas;
    }
    
    
}
