/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Zhipeng
 */
public class ImageOkEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitDataModel parentModel;
    private final AddImageDataModel model;
    private final Stage stage;

    public ImageOkEventHandler(DataUnitDataModel parentModel, AddImageDataModel model, Stage stage) {
        this.parentModel = parentModel;
        this.model = model;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        ImageLink link = new ImageLink();
        link.setLink(model.getImageFileLink());
        link.setInformation(model.getInformation());
        
        parentModel.add(link);
    }

}
