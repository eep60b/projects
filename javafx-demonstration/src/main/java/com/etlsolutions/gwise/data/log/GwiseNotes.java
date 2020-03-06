package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseNotes extends GwiseLogGroup {

    public GwiseNotes(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, years);
    }

    public GwiseNotes(GwiseLogGroupBean bean) {
        super(bean);
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
