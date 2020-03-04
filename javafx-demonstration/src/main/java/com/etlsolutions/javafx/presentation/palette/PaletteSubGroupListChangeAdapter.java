package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.DataUnitTitleComparator;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.gwise.system.ProjectManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zc
 */
public class PaletteSubGroupListChangeAdapter implements ListChangeListener<PlantSubGroup> {

    private final TilePane plantsTilePane;

    public PaletteSubGroupListChangeAdapter(TilePane plantsTilePane) {
        this.plantsTilePane = plantsTilePane;
    }

    @Override
    public void onChanged(Change<? extends PlantSubGroup> c) {
        
        plantsTilePane.getChildren().clear();
        
        List<PlantSubGroup> subgroups = new ArrayList<>();
        for(PlantGroup group : ProjectManager.getInstance().getContents().getPlantsGroupRoot().getPlantGroups()) {
            subgroups.addAll(group.getPlantSubGroups());
        }

        Collections.sort(subgroups, new DataUnitTitleComparator());
        
        for(PlantSubGroup subGroup : subgroups) {            
            ImageView view = new ImageView(new Image(subGroup.getLogoPath()));
            view.setOnMouseClicked(new PlantSubGroupMouseClickEventHandler(subGroup));
            view.setOnDragDetected(new ImageViewDragDetectedEventHandler());
            view.setOnDragDone(new ImageViewDragDoneEventHandler());
            plantsTilePane.getChildren().add(view);
        }
    }
    
}
