package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseFarmArea extends GwiseArea {

    public GwiseFarmArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseFarmArea(GwiseFarmAreaBean bean) {
        super(bean);
    }

    @Override
    public AreaType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GwiseFarmAreaBean getBean() {
        return new GwiseFarmAreaBean(this);
    }   
}
