package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class PlantType extends GwiseDataUnit {

    public PlantType(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public PlantType(PlantTypeBean bean) {
        super(bean);
    }

    @Override
    public PlantTypeBean getBean() {
        return new PlantTypeBean(this);
    }

    

}
