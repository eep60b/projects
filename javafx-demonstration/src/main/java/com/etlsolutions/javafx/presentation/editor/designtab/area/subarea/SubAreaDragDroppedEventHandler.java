package com.etlsolutions.javafx.presentation.editor.designtab.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author ZhipengChang
 */
public class SubAreaDragDroppedEventHandler implements EventHandler<DragEvent> {

    private final StackPane designPane;    
    private final DesignPaneSubAreaDataModel model;

    public SubAreaDragDroppedEventHandler(StackPane designPane, DesignPaneSubAreaDataModel model) {
        this.designPane = designPane;
        this.model = model;
    }

    @Override
    public void handle(DragEvent event) {
        ParameterisedImageView view = (ParameterisedImageView) event.getGestureSource();
        Object[] parameters = view.getParameters();

        if (parameters == null || parameters.length == 0) {
            return;
        }

        PlantSubGroup subGroup = (PlantSubGroup) parameters[0];
        model.addPropertyChangeListener(DesignPaneSubAreaDataModel.PLANT_SUBGROUP_DROPPED_PROPERTY, new DesignPanePlantSubgroupDroppedPropertyChangeAdapter(designPane));
        model.drop(subGroup);
    }

}
