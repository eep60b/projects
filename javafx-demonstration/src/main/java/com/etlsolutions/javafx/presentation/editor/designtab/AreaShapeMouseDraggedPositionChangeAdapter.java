package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.gwise.system.ProjectManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author ZhipengChang
 */
public class AreaShapeMouseDraggedPositionChangeAdapter implements ChangeListener<Point2D> {

    private final Shape shape;
    private final Button addAreaButton;

    public AreaShapeMouseDraggedPositionChangeAdapter(Shape shape, Button addAreaButton) {
        this.shape = shape;
        this.addAreaButton = addAreaButton;
    }


    @Override
    public void changed(ObservableValue<? extends Point2D> observable, Point2D oldValue, Point2D newValue) {

        shape.setTranslateX(newValue.getX() - oldValue.getX());
        shape.setTranslateY(newValue.getY() - oldValue.getY());

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

    }
}
