/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        model.setSelectedImageLink(image.getLink());
    }
}
