package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.DataUnitTitleComparator;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zc
 */
public class ProjectContentsPalettePropertyChangeAdaper implements PropertyChangeListener {

    private final TilePane plantsTilePane;

    public ProjectContentsPalettePropertyChangeAdaper(TilePane plantsTilePane) {
        this.plantsTilePane = plantsTilePane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ProjectContents pc = (ProjectContents) evt.getSource();
        process(pc);
    }

    public void process(ProjectContents pc) {
        
        plantsTilePane.getChildren().clear();
        if (pc != null) {

            List<PlantSubGroup> subgroups = new ArrayList<>();
            for (PlantGroup group : pc.getPlantsGroupRoot().getPlantGroups()) {

                ObservableListWrapperA<PlantSubGroup> sgps = group.getPlantSubGroups();
                subgroups.addAll(sgps);
                sgps.replaceListenerForClass(plantsTilePane.getClass().getName(), new PaletteSubGroupListChangeAdapter(plantsTilePane));
            }

            Collections.sort(subgroups, new DataUnitTitleComparator());

            for (PlantSubGroup subGroup : subgroups) {
                ImageView view = new ImageView(new Image(subGroup.getLogoPath()));
                view.setOnMouseClicked(new PlantSubGroupMouseClickEventHandler(subGroup));
                view.setOnDragDetected(new PlantSubGroupImageViewDragDetectedEventHandler());
                view.setOnDragDone(new PlantSubGroupImageViewDragDoneEventHandler());
                plantsTilePane.getChildren().add(view);
            }
        }

    }
}
