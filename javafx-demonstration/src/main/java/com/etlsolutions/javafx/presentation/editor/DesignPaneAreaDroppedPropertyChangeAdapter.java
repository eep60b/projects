package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.javafx.presentation.editor.designtab.area.AreaDragDroppedEventHandler;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.presentation.editor.designtab.area.DesignPaneAreaDataModel;
import com.etlsolutions.gwise.system.ProjectManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * After the area shape being dropped to the design pane by the mouse, the mouse
 * event is done by creating an area object and adding it to the project
 * manager. The DesignPaneAreaDroppedPropertyChangeAdapter class listen to the
 * property change event in the project manage and add an area shape to the
 * design pane.
 *
 * @author ZhipengChang
 */
public class DesignPaneAreaDroppedPropertyChangeAdapter implements PropertyChangeListener {

    private final StackPane designPane;

    public DesignPaneAreaDroppedPropertyChangeAdapter(StackPane designPane) {
        this.designPane = designPane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        Area area = (Area) ProjectManager.getInstance().getSelectedDataUnitValueWrapper().getValue();

        Shape areaShape;

        switch (area.getShapeType()) {
            case POLYGON:

                ObservableListWrapperA<GwisePoint> sps = area.getPoints();
                int size = sps.size();
                double[] points = new double[size * 2];

                for (int i = 0; i < size; i++) {

                    GwisePoint s = sps.get(i);
                    points[i * 2] = s.getX();
                    points[i * 2 + 1] = s.getY();
                }

                areaShape = new Polygon(points);
                designPane.getChildren().add(areaShape);
                break;

            default:
                throw new IllegalStateException("Invalid area shape.");
        }

        DesignPaneAreaDataModel areaModel = new DesignPaneAreaDataModel(area);
        areaModel.addPropertyChangeListener(DesignPaneAreaDataModel.SUBAREA_DROPPED_PROPERTY, new DesignPaneSubAreaDroppedPropertyChangeAdapter(designPane));
        areaShape.setUserData(areaModel);
        areaShape.setOnDragDropped(new AreaDragDroppedEventHandler(areaModel));
    }

}
