package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.javafx.data.DataUnitTitleComparator;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.PropertyChangeAdapter;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.presentation.palette.ImageViewDragDetectedEventHandler;
import com.etlsolutions.javafx.presentation.palette.ImageViewDragDoneEventHandler;
import com.etlsolutions.javafx.presentation.palette.PaletteSubGroupListChangeAdapter;
import com.etlsolutions.javafx.presentation.palette.PlantSubCroupMouseEnterEventHandler;
import com.etlsolutions.javafx.presentation.palette.PlantSubGroupMouseClickEventHandler;
import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
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
public class GwiseProjectContentsPalettePropertyChangeAdaper extends PropertyChangeAdapter<TilePane> {

    public GwiseProjectContentsPalettePropertyChangeAdaper(TilePane plantsTilePane) {
        super(plantsTilePane);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ValueWrapper<ProjectContents> wrapper = (ValueWrapper<ProjectContents>) evt.getSource();
        process(wrapper.getValue());
    }

    public void process(ProjectContents pc) {
        
        source.getChildren().clear();
        if (pc != null) {

            List<PlantSubGroup> subgroups = new ArrayList<>();
            for (PlantGroup group : pc.getPlantsGroupRoot().getPlantGroups()) {

                ObservableListWrapperA<PlantSubGroup> sgps = group.getPlantSubGroups();
                subgroups.addAll(sgps);
                sgps.replaceListenerForClass(source.getClass().getName(), new PaletteSubGroupListChangeAdapter(source));
            }

            Collections.sort(subgroups, new DataUnitTitleComparator());

            for (PlantSubGroup subGroup : subgroups) {
                try {
                    ImageView view = new ParameterisedImageView(new Image(new File(subGroup.getLogoPath()).toURI().toURL().toString()), subGroup);
                    view.setOnMouseClicked(new PlantSubGroupMouseClickEventHandler(subGroup));
                    view.setOnDragDetected(new ImageViewDragDetectedEventHandler());
                    view.setOnDragDone(new ImageViewDragDoneEventHandler());
                    view.setOnMouseEntered(new PlantSubCroupMouseEnterEventHandler(subGroup));
                    source.getChildren().add(view);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(getClass()).error(ex);
                    throw new CustomLevelErrorRuntimeExceiption(ex);
                }
            }
        }

    }
}
