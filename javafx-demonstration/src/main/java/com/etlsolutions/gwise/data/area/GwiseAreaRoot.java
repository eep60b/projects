package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.List;

/**
 * The Area root has the title of "All Areas", no logo, no information and no
 * image links.
 *
 * @author ZhipengChang
 */
public class GwiseAreaRoot extends GwiseDataUnit {

    private final ObservableListWrapperA<GwiseArea> areas;

    public GwiseAreaRoot(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, 
            ObservableListWrapperA<GwiseArea> areas) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.areas = new ObservableListWrapperA<>(areas);
    }

    public GwiseAreaRoot(GwiseDataUnitBean bean) {
        super(bean);
        areas = new ObservableListWrapperA<>();
    }


    public GwiseAreaRoot(GwiseAreaRootBean bean) {
        super(bean);
        areas = new ObservableListWrapperA<>();
        for (GwiseAreaBean a : bean.getAreas()) {

            switch (a.type()) {
                case ALLOTMENT:
                    areas.add(new GwiseAllotmentArea((GwiseAllotmentAreaBean) a));
            }
        }
    }

    public ObservableListWrapperA<GwiseArea> getAreas() {
        return areas;
    }

    @Override
    public GwiseAreaRootBean getBean() {
        return new GwiseAreaRootBean(this);
    }
}
