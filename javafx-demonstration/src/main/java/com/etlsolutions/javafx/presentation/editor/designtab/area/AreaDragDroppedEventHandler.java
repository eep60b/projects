package com.etlsolutions.javafx.presentation.editor.designtab.area;

import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

/**
 *
 * @author ZhipengChang
 */
public class AreaDragDroppedEventHandler implements EventHandler<DragEvent> {

    private final DesignPaneAreaDataModel model;

    public AreaDragDroppedEventHandler(DesignPaneAreaDataModel model) {

        this.model = model;
    }

    @Override
    public void handle(DragEvent event) {
        
        ParameterisedImageView view = (ParameterisedImageView) event.getGestureSource();
        Object[] parameters = view.getParameters();

        if (parameters == null || parameters.length == 0) {
            return;
        }

        SubAreaType type = (SubAreaType) parameters[0];
        SubAreaShape shape = (SubAreaShape) parameters[1];
        model.drop(type, shape);
    }
}