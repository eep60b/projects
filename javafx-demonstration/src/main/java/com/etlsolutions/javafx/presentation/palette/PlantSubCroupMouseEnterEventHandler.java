package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author ZhipengChang
 */
public class PlantSubCroupMouseEnterEventHandler implements EventHandler<MouseEvent> {

    public PlantSubCroupMouseEnterEventHandler(PlantSubGroup subGroup) {
    }

    @Override
    public void handle(MouseEvent event) {
        ImageView view = (ImageView) event.getSource();
        
       
    }
    
}
