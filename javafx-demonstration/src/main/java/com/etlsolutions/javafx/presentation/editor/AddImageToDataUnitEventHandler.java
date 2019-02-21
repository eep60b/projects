package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.presentation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class AddImageToDataUnitEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new AddImageToDataUnitDataModel()).handle(event);
    }
}
