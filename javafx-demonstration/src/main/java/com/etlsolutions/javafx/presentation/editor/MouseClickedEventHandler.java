package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public class MouseClickedEventHandler implements EventHandler<MouseEvent> {

    private final DataUnit dataUnit;

    public MouseClickedEventHandler(DataUnit dataUnit) {
        this.dataUnit = dataUnit;
    }

    @Override
    public void handle(MouseEvent event) {
        
        //TODO: display a dialog to show information.
    }
    
}
