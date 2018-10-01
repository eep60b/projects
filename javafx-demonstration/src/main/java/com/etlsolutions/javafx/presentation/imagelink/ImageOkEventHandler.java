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
    private final ImageDataModel model;

    public ImageOkEventHandler(DataUnitDataModel parentModel, ImageDataModel model) {
        this.parentModel = parentModel;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {        
        parentModel.getImageLinks().add(new ImageLink(model.getImageFileLink(), model.getInformation()));
    }

}
