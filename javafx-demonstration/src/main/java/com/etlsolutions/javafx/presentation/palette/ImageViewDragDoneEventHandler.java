package com.etlsolutions.javafx.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;

/**
 *
 * @author zc
 */
public class ImageViewDragDoneEventHandler implements EventHandler<DragEvent> {

    public ImageViewDragDoneEventHandler() {
    }

    @Override
    public void handle(DragEvent event) {

        //TODO: Recover the image colour.
        ImageView v = (ImageView) event.getSource();

        event.consume();
    }

}
