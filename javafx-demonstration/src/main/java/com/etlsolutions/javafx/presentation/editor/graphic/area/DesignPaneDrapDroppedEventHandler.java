package com.etlsolutions.javafx.presentation.editor.graphic.area;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.presentation.editor.model.DesignPaneDataModel;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

/**
 *
 * @author zc
 */
public class DesignPaneDrapDroppedEventHandler implements EventHandler<DragEvent> {

    private final DesignPaneDataModel model;

    public DesignPaneDrapDroppedEventHandler(DesignPaneDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(DragEvent event) {
 
        //Not sure if we need this.
        event.acceptTransferModes(TransferMode.ANY);
        
        // get the current mouse coordinates according to the scene.
        double mouseX = event.getSceneX();
        double mouseY = event.getSceneY();
        
        Canvas canvas = (Canvas)event.getSource();
        
        canvas.getParent();
        
        ParameterisedImageView view = (ParameterisedImageView) event.getGestureSource();
        Object[] parameters = view.getParameters();
        
        if(parameters == null || parameters.length == 0) {
            return;
        }
        
        if(parameters[0] instanceof PlantSubGroup) {
            PlantSubGroup subGroup = (PlantSubGroup) parameters[0];
            model.drop(mouseX, mouseY, subGroup);
        }        
    }

}
