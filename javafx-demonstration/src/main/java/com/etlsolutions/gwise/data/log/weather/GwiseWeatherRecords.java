package com.etlsolutions.gwise.data.log.weather;

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
public class GwiseWeatherRecords extends GwiseLogGroup{

    public GwiseWeatherRecords(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, years);
    }

    public GwiseWeatherRecords(GwiseLogGroupBean bean) {
        super(bean);
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
