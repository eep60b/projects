package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.data.plant.PlantType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author ZhipengChang
 */
public class PlantTypeMouseClickEventHandler implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent event) {
        
        PlantTypeImageView view = (PlantTypeImageView) event.getSource();        
        PlantType type = view.getType();
        
        //display a dialog
    }
    
}
