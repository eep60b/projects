package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.data.GwiseDataUnitTitleComparator;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.PropertyChangeAdapter;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.plant.GwisePlantGroup;
import com.etlsolutions.gwise.data.plant.PlantType;
import com.etlsolutions.gwise.system.CustomLevelErrorRuntimeExceiption;
import com.etlsolutions.gwise.system.GwiseProjectContents;
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

        ValueWrapper<GwiseProjectContents> wrapper = (ValueWrapper<GwiseProjectContents>) evt.getSource();
        process(wrapper.getValue());
    }

    public void process(GwiseProjectContents pc) {
        
        source.getChildren().clear();
        if (pc != null) {

            //Create this list to diaplay them in the pallette area.
            List<PlantType> plantTypes = new ArrayList<>();
            for (GwisePlantGroup group : pc.getPlantsGroupRoot().getPlantGroups()) {

                ObservableListWrapperA<PlantType> sgps = group.getPlantTypes();
                plantTypes.addAll(sgps);
                //Add a listener to listen to the change of plant type of this plant group. This is done only when the project is changed or created.
                sgps.addListener(new PlantTypeListChangeAdapter(source));
            }

            Collections.sort(plantTypes, new GwiseDataUnitTitleComparator());

            for (PlantType plantType : plantTypes) {
                try {
                    ImageView view = new PlantTypeImageView(plantType, new Image(new File(plantType.getLogoPath()).toURI().toURL().toString()));
                    view.setOnMouseClicked(new PlantTypeMouseClickEventHandler());
                    view.setOnDragDetected(new DragDetectedEventHandler());
                    view.setOnDragDone(new DragDoneEventHandler());
                    view.setOnMouseEntered(new PlantTypeMouseEnterEventHandler());
                    source.getChildren().add(view);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(getClass()).error(ex);
                    throw new CustomLevelErrorRuntimeExceiption(ex);
                }
            }
        }
    }
}
