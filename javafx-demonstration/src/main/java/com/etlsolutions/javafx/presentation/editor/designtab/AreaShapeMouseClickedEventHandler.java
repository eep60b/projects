package com.etlsolutions.javafx.presentation.editor.designtab;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author ZhipengChang
 */
public class AreaShapeMouseClickedEventHandler implements EventHandler<MouseEvent> {

    private final AreaShapeDataModel shapeDataModel;

    public AreaShapeMouseClickedEventHandler(AreaShapeDataModel shapeDataModel) {
        this.shapeDataModel = shapeDataModel;
    }

    @Override
    public void handle(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
