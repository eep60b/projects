package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.gwise.data.ImageLink;
import javafx.scene.image.Image;

/**
 *
 * @author zc
 */
public class LocallyLinkedImage extends Image {

    private final ImageLink link;
    
    public LocallyLinkedImage(ImageLink link) {
        super(link.getLink());
        this.link = link;
    }

    public ImageLink getLink() {
        return link;
    }
}
