package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * The AddItemToDesignPaneEventHandler class is an event handler which create
 * the area or sub area after the add button is clicked.
 *
 * @author ZhipengChang
 */
public class AddItemToDesignPaneEventHandler implements EventHandler<ActionEvent> {

    private final StackPane designPane;

    public AddItemToDesignPaneEventHandler(StackPane designPane) {
        this.designPane = designPane;
    }

    /**
     * 1. Remove the shape before any action.
     *
     * 2. Add an area/sub area.
     *
     * @param event - The action event object.
     */
    @Override
    public void handle(ActionEvent event) {

        if (designPane.isDisabled()) {

            ObservableList<Node> children = designPane.getChildren();
            Node n = children.get(children.size() - 1);
            children.remove(n);
            designPane.setDisable(false);

            if (n instanceof Shape) {

                Shape sh = (Shape) n;
                Object userData = sh.getUserData();

                if (userData instanceof AreaType) {

                    AreaType type = (AreaType) userData;

                    AreaFactory af = AreaFactory.getInstance();
                    Area area;
                    if (sh instanceof Polygon) {
                        area = af.createPolygonArea(type, ((Polygon) sh).getPoints());

                    } else if (sh instanceof Rectangle) {

                        Rectangle r = (Rectangle) sh;

                        area = af.createRectangleArea(type, AreaShape.RECTANGLE, r.getX(), r.getY(), r.getWidth(), r.getHeight());
                    } else if (sh instanceof Circle) {
                        Circle c = (Circle) sh;
                        area = af.createCircleArea(type, c.getCenterX(), c.getCenterY(), c.getRadius());
                    } else if (sh instanceof Path) {

                        Path p = (Path) sh;

                        area = af.createIrregularArea(type, p.getElements());
                    } else {
                        throw new IllegalStateException("Invalid shape.");
                    }
                    
                    ProjectManager.getInstance().addItem(area);
                    ProjectManager.getInstance().getSelectedDataUnitValueWrapper().setValue(area);
                    return;
                }

                if (userData instanceof SubAreaType) {

                    //TODO:

                }
            }
        }
    }
}
