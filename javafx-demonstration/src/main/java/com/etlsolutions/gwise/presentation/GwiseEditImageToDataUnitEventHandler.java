package com.etlsolutions.gwise.presentation;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.javafx.presentation.dialog.imagelink.EditImageInformationDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class GwiseEditImageToDataUnitEventHandler implements EventHandler<ActionEvent> {

        GwiseDataUnitFXMLDataModel model;
        
        public GwiseEditImageToDataUnitEventHandler(GwiseDataUnitFXMLDataModel model) {
            this.model = model;
        }

        @Override
        public void handle(ActionEvent event) {
            new FXMLActionEventHandler<>(new EditImageInformationDataModel((ImageLink) model.getSelectedImageLinkWrapper().getValue())).handle(event);
        }
    }