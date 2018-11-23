package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public class ImageViewMouseClickEventHandler implements EventHandler<MouseEvent> {

    private final DataUnitFXMLDataModel model;

    public ImageViewMouseClickEventHandler(DataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        LocallyLinkedImage image = (LocallyLinkedImage) ((ImageView) event.getSource()).getImage();
        model.getSelectedImageLinkWrapper().setValue(image.getLink());
    }
}
