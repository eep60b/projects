package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.gwise.presentation.palette.DragDoneEventHandler;
import com.etlsolutions.gwise.presentation.palette.DragDetectedEventHandler;
import com.etlsolutions.javafx.data.DataUnitTitleComparator;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.gwise.presentation.ParameterisedImageView;
import com.etlsolutions.gwise.system.CustomLevelErrorRuntimeExceiption;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import org.apache.log4j.Logger;

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

        ValueWrapper<ProjectContents> wrapper = (ValueWrapper<ProjectContents>) evt.getSource();
        process(wrapper.getValue());
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
                try {
                    ImageView view = new ParameterisedImageView(new Image(new File(subGroup.getLogoPath()).toURI().toURL().toString()), subGroup);
                    view.setOnMouseClicked(new PlantSubGroupMouseClickEventHandler(subGroup));
                    view.setOnDragDetected(new DragDetectedEventHandler());
                    view.setOnDragDone(new DragDoneEventHandler());
 //                   view.setOnMouseEntered(new GwiseSubareaMouseEnterEventHandler(subGroup));
                    plantsTilePane.getChildren().add(view);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(getClass()).error(ex);
                    throw new CustomLevelErrorRuntimeExceiption(ex);
                }
            }
        }

    }
}
