package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.log.GwiseLogGroup;
import com.etlsolutions.gwise.data.log.GwiseLogGroupBean;
import com.etlsolutions.gwise.data.log.GwiseLogYear;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseReferences extends GwiseLogGroup {

    public GwiseReferences(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, years);
    }

    public GwiseReferences(GwiseLogGroupBean bean) {
        super(bean);
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
