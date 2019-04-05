package com.etlsolutions.javafx.presentation.editor.graphic.area;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

/**
 * TODO:
 *
 * 1. If the object is a plant bed/pond/raised bed/lawn, 1) add an newly created
 * default SubArea object to the area. 2) Add an 2D image to the canvas graphic.
 * 3) Display a dialog and ask user for the shape. The irregular shape cannot be
 * dragged and doesn't have a border.
 *
 * 2. If the object is greenhouse or room, add an newly created default
 * greenhouse or room. The shape of greenhouse can only be rectangle or round.
 * The room can only be rectangle.
 *
 * 3. If the object is a single container, add a default ContainerSet with a
 * default container.
 *
 * 4. If the object is a set of container, pop a dialog to ask user how many
 * containers.
 *
 * 5. If the object is a PlantSubGroup, create a default location in the subarea. If no
 * subarea is selected, create a default plant bed with border. 
 *
 * @author zc
 */
public class CanvasDrapDroppedEventHandler implements EventHandler<DragEvent> {

    public CanvasDrapDroppedEventHandler() {
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
            
        }
    }

}
