package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.gwise.data.subarea.GwiseSubareaBean;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseArea extends GwiseDataUnit {

    private final ObservableListWrapperA<GwiseSubarea> subareas;
    private final AreaType type;

    public GwiseArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            AreaType type, List<GwiseSubarea> subareas) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.type = type;
        this.subareas = new ObservableListWrapperA<>(subareas);
    }

    public GwiseArea(GwiseAreaBean bean) {
        super(bean);
        type = bean.getType();
        subareas = new ObservableListWrapperA<>();
        for (GwiseSubareaBean subarea : bean.getSubareas()) {
            subareas.add(new GwiseSubarea(subarea));
        }
    }

    public AreaType getType() {
        return type;
    }

    public final ObservableListWrapperA<GwiseSubarea> getSubareas() {
        return subareas;
    }

    @Override
    public GwiseAreaBean getBean() {
        return new GwiseAreaBean(this);
    }
}
