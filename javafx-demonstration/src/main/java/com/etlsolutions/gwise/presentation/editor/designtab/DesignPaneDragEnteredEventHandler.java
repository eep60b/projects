package com.etlsolutions.gwise.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.GwiseShapeType;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.presentation.editor.designtab.AreaShapeDataModel;
import com.etlsolutions.javafx.presentation.editor.designtab.AreaShapeMouseClickedEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.AreaShapeMouseDraggedEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.AreaShapeMouseDraggedPositionChangeAdapter;
import com.etlsolutions.javafx.presentation.editor.designtab.AreaShapeMousePressedEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.AreaShapeMouseReleasedEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDataModel;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * The DesignPaneDragEnteredEventHandler class handles the event when the mouse
 * cursor entered into the design pane.
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
     * When the moused entered into the design pane, a shape with the default
     * size is created.
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

                GwiseShapeType areaShape = (GwiseShapeType) parameters[1];

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

                AreaShapeDataModel shapeDataModel = new AreaShapeDataModel(areaShape, x, y);

                shape.setOnMouseClicked(new AreaShapeMouseClickedEventHandler(shapeDataModel));
                shape.setOnMousePressed(new AreaShapeMousePressedEventHandler(shapeDataModel));
                shape.setOnMouseReleased(new AreaShapeMouseReleasedEventHandler(shapeDataModel));
                shape.setOnMouseDragged(new AreaShapeMouseDraggedEventHandler(shapeDataModel));

                designPane.getChildren().add(shape);

                shapeDataModel.getMouseDraggedPosition().addListener(new AreaShapeMouseDraggedPositionChangeAdapter(shape, addAreaButton));
            }
        }
    }

    private Shape getShape(double x, double y, GwiseShapeType areaShape) {

        switch (areaShape) {

            case CIRCLE:
                return new Circle(x, y, 100);
            case RECTANGLE:
                return new Rectangle(x, y, 100, 100);
            case POLYGON:
                return new Polygon(x, y, x + 100, y + 100, x + 100, y + 100, x + 100, y + 100, x + 500, y + 500);
            case TRIANGLE:
                return new Polygon(x, y, x + 100, y + 100, x + 100, y + 100, x + 100, y + 100, x + 500, y + 500);
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }

    }
}
