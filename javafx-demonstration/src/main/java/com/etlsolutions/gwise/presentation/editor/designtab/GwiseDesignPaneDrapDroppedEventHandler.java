package com.etlsolutions.gwise.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

/**
 * The DesignPaneDrapDroppedEventHandler class process the operations which
 * receive an area item before drop the item into the background design stack
 * pane. The event handler is attached to the design line chart for measuring
 * the dropping location.
 *
 * @author zc
 */
public class GwiseDesignPaneDrapDroppedEventHandler implements EventHandler<DragEvent> {

    private final GwiseDesignPaneDataModel model;

    public GwiseDesignPaneDrapDroppedEventHandler(GwiseDesignPaneDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(DragEvent event) {

        //Not sure if we need this.
        event.acceptTransferModes(TransferMode.ANY);

        ParameterisedImageView view = (ParameterisedImageView) event.getGestureSource();
        Object[] parameters = view.getParameters();

        if (parameters == null || parameters.length == 0) {
            return;
        }

        AreaType type = (AreaType) parameters[0];
  
    }
}
