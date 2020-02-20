package com.etlsolutions.javafx.presentation;

import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.dialog.imagelink.EditImageInformationDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class EditImageToDataUnitEventHandler implements EventHandler<ActionEvent> {

        DataUnitFXMLDataModel model;
        
        public EditImageToDataUnitEventHandler(DataUnitFXMLDataModel model) {
            this.model = model;
        }

        @Override
        public void handle(ActionEvent event) {
            new FXMLActionEventHandler<>(new EditImageInformationDataModel((ImageLink) model.getSelectedImageLinkWrapper().getValue())).handle(event);
        }
    }