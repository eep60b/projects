package com.etlsolutions.javafx.presentation.menu.add.area;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author zc
 */
public class CustomAreaContent extends VBox {

    public CustomAreaContent(AddAreaDialogDataModel model) {
        setSpacing(10);
        HBox plantBedHbox = new HBox();
        plantBedHbox.setSpacing(10);
        Label plantBedLabel = new Label("Plant Bed");
        Button addPlantBedButton = new Button("Add");
        Button removePlantBedButton = new Button("Remove");
        Button editPlantBedButton = new Button("Edit");
        plantBedHbox.getChildren().addAll(plantBedLabel, addPlantBedButton, removePlantBedButton, editPlantBedButton);
    }
    
    
}
