package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 * The LogItem class is a mask class to define all the log related objects.
 *
 * @author ZhipengChang
 */
public abstract class LogItem extends GwiseDataUnit {

    public LogItem(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public LogItem(LogItemBean bean) {
        super(bean);
    }
}
