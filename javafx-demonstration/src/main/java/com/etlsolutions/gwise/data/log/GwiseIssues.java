package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseIssues extends GwiseLogGroup {   

    public GwiseIssues(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, years);
    }

    public GwiseIssues(GwiseIssuesBean bean) {
        super(bean);
    }

    @Override
    public GwiseIssuesBean getBean() {
        return new GwiseIssuesBean(this);
    }


}
