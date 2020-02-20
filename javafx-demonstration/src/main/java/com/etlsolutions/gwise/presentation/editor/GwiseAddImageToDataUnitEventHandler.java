package com.etlsolutions.gwise.presentation.editor;

import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class GwiseAddImageToDataUnitEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new AddImageToGwiseDataUnitDataModel()).handle(event);
    }
}
