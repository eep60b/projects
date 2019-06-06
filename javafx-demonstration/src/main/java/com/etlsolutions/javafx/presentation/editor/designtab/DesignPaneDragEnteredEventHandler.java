package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.system.ProjectManager;
import java.awt.Paint;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;

/**
 *
 * @author zc
 */
public class DesignPaneDragEnteredEventHandler implements EventHandler<DragEvent> {

    private final StackPane designPane;
    private final DesignPaneDataModel model;

    public DesignPaneDragEnteredEventHandler(StackPane designPane, DesignPaneDataModel model) {
        this.designPane = designPane;
        this.model = model;
    }

    /**
     *
     *
     * TODO: shade the area occupied. (Add a shape same as the source object)
     *
     * @param event
     */
    @Override
    public void handle(DragEvent event) {

        Object o = event.getGestureSource();

        if (o instanceof ParameterisedImageView) {
            ParameterisedImageView p = (ParameterisedImageView) o;
            Object[] parameters = p.getParameters();

            if (parameters[0] instanceof AreaType) {

                AreaShape areaShape = (AreaShape) parameters[1];

                double x = event.getSceneX();
                double y = event.getSceneY();

                Shape shape = getShape(x, y, areaShape);

                for (Area a : ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas()) {
                    Shape s = Shape.intersect(shape, a.shape());
                    if (s.getFill() == null) {
                        shape.setFill(null);
                    } else {
                        shape.setFill(null);
                    }
                }
                
                shape.setOnMouseClicked(new AreaShapeMouseClickedEventHandler());
                shape.setOnMousePressed(new AreaShapeMousePressedEventHandler());
                shape.setOnMouseReleased(new AreaShapeMouseReleasedEventHandler());
                shape.setOnMouseDragged(new AreaShapeMouseDraggedEventHandler());
            }
        }
    }

    private Shape getShape(double x, double y, AreaShape areaShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
