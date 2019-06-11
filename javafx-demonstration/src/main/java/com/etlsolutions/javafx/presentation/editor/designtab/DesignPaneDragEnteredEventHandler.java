package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author zc
 */
public class DesignPaneDragEnteredEventHandler implements EventHandler<DragEvent> {

    private final StackPane designPane;
    private final Button addAreaButton;
    private final Button cancelAreaButton;
    private final DesignPaneDataModel model;

    public DesignPaneDragEnteredEventHandler(StackPane designPane, Button addAreaButton, Button cancelAreaButton, DesignPaneDataModel model) {
        this.designPane = designPane;
        this.addAreaButton = addAreaButton;
        this.cancelAreaButton = cancelAreaButton;
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

                addAreaButton.setVisible(true);
                cancelAreaButton.setVisible(true);
                cancelAreaButton.setDisable(false);

                AreaShape areaShape = (AreaShape) parameters[1];

                double x = event.getSceneX();
                double y = event.getSceneY();

                Shape shape = getShape(x, y, areaShape);
                shape.setUserData(parameters[0]);

                boolean intersect = false;

                for (Area a : ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas()) {

                    Shape s = Shape.intersect(shape, a.shape());

                    if (s.getFill() != null) {
                        intersect = true;
                        break;
                    }
                }

                shape.setFill(intersect ? Color.RED : Color.GREEN);
                addAreaButton.setDisable(intersect);

                AreaShapeDataModel shapeDataModel = new AreaShapeDataModel();
                shape.setOnMouseClicked(new AreaShapeMouseClickedEventHandler(shapeDataModel));
                shape.setOnMousePressed(new AreaShapeMousePressedEventHandler(shapeDataModel));
                shape.setOnMouseReleased(new AreaShapeMouseReleasedEventHandler(shapeDataModel));
                shape.setOnMouseDragged(new AreaShapeMouseDraggedEventHandler(shapeDataModel));
                
                designPane.getChildren().add(shape);
                
                shapeDataModel.getMouseDraggedPosition().addListener(new AreaShapeMouseDraggedPositionChangeAdapter(shape, addAreaButton));
                
                
            }
        }
    }

    private Shape getShape(double x, double y, AreaShape areaShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
