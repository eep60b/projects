package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class AddImageToDataUnitEventHandler implements EventHandler<ActionEvent> {

        DataUnitFXMLDataModel model;
        
        public AddImageToDataUnitEventHandler(DataUnitFXMLDataModel model) {
            this.model = model;
        }

        @Override
        public void handle(ActionEvent event) {
            new FXMLActionEventHandler<>(new AddImageDataModel(model)).handle(event);
        }
    }