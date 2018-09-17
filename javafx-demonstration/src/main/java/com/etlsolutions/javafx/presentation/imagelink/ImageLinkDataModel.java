package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import java.util.List;

/**
 *
 * @author zc
 */
public interface ImageLinkDataModel {
    
    
    void add(ImageLink link);
    
    void remove(ImageLink link);
    
    List<ImageLink> getImageLinks();
}
