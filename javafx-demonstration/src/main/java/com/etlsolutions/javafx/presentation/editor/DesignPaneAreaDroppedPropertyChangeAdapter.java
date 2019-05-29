package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.editor.designtab.area.AreaDragDroppedEventHandler;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.presentation.editor.designtab.area.DesignPaneAreaDataModel;
import com.etlsolutions.javafx.system.ProjectManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
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
        
        switch(area.getShape()) {
            case POLYGON:
                areaShape =  new Polygon(area.getPoints());    
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
