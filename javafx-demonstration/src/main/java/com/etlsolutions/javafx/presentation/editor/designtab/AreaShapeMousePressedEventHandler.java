package com.etlsolutions.javafx.presentation.editor.designtab;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author ZhipengChang
 */
public class AreaShapeMousePressedEventHandler implements EventHandler<MouseEvent> {

    private final AreaShapeDataModel shapeDataModel;

    public AreaShapeMousePressedEventHandler(AreaShapeDataModel shapeDataModel) {
        this.shapeDataModel = shapeDataModel;
    }

    @Override
    public void handle(MouseEvent event) {
        //TODO:
    }
    
}
