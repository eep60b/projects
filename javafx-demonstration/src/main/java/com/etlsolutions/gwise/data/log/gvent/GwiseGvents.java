package com.etlsolutions.gwise.data.log.gvent;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.area.GwiseAllotmentAreaBean;
import com.etlsolutions.gwise.data.log.GwiseLogGroup;
import com.etlsolutions.gwise.data.log.GwiseLogGroupBean;
import com.etlsolutions.gwise.data.log.GwiseLogYear;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author Zhipeng
 */
public class GwiseGvents extends GwiseLogGroup {

    public GwiseGvents(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, years);
    }

    public GwiseGvents(GwiseLogGroupBean bean) {
        super(bean);
    }

    @Override
    public GwiseGventsBean getBean() {
        return new GwiseGventsBean(this);
    }
}
