package com.etlsolutions.gwise.presentation.editor.designtab;

import com.etlsolutions.gwise.data.area.AreaType;
import com.etlsolutions.gwise.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDataModel;
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
public class DesignPaneDrapDroppedEventHandler implements EventHandler<DragEvent> {

    private final DesignPaneDataModel model;

    public DesignPaneDrapDroppedEventHandler(DesignPaneDataModel model) {
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
        model.drop(type);
    }
}
