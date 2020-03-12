package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.data.GwiseDataUnitTitleComparator;
import com.etlsolutions.gwise.data.plant.GwisePlantGroup;
import com.etlsolutions.gwise.data.plant.PlantType;
import com.etlsolutions.gwise.system.ProjectManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 * The PlantTypeListChangeAdapter class listens to the change of the list of 
 * @author zc
 */
public class PlantTypeListChangeAdapter implements ListChangeListener<PlantType> {

    private final TilePane plantsTilePane;

    public PlantTypeListChangeAdapter(TilePane plantsTilePane) {
        this.plantsTilePane = plantsTilePane;
    }

    @Override
    public void onChanged(Change<? extends PlantType> c) {
        
        plantsTilePane.getChildren().clear();
        
        List<PlantType> plantTypes = new ArrayList<>();
        for(GwisePlantGroup group : ProjectManager.getInstance().getGwiseProjectContents().getPlantsGroupRoot().getPlantGroups()) {
            plantTypes.addAll(group.getPlantTypes());
        }

        Collections.sort(plantTypes, new GwiseDataUnitTitleComparator());
        
        for(PlantType type : plantTypes) {            
            ImageView view = new ImageView(new Image(type.getLogoPath()));
            view.setOnMouseClicked(new PlantTypeMouseClickEventHandler());
            view.setOnDragDetected(new DragDetectedEventHandler());
            view.setOnDragDone(new DragDoneEventHandler());
            plantsTilePane.getChildren().add(view);
        }
    }
    
}
