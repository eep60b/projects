package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.data.plant.PlantType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * The PlantTypeMouseDragEventHandler class handles the drag event after the
 * user push down the mouse click and start to move.
 *
 * @author zc
 */
public class PlantTypeMouseDragEventHandler implements EventHandler<MouseEvent> {

    private final PlantType type;

    public PlantTypeMouseDragEventHandler(PlantType type) {
        this.type = type;
    }

    @Override
    public void handle(MouseEvent event) {
        //This event will crreate a new window.
    }
}
