package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.editor.designtab.area.subarea.DesignPaneSubAreaDataModel;
import com.etlsolutions.javafx.presentation.editor.designtab.area.subarea.SubAreaDragDroppedEventHandler;
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
public class DesignPaneSubAreaDroppedPropertyChangeAdapter implements PropertyChangeListener {

    private final StackPane designPane;

    public DesignPaneSubAreaDroppedPropertyChangeAdapter(StackPane designPane) {
        this.designPane = designPane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        SubArea subArea = (SubArea) ProjectManager.getInstance().getSelectedDataUnitValueWrapper().getValue();
        
        Shape shape = new Polygon(subArea.getPoints());
        
        DesignPaneSubAreaDataModel model = new DesignPaneSubAreaDataModel(subArea);
        
        shape.setUserData(model);
        shape.setOnDragDropped(new SubAreaDragDroppedEventHandler(designPane, model));
    }
}
