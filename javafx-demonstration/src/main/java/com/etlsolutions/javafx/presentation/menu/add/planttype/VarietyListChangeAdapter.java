package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class VarietyListChangeAdapter implements ListChangeListener<PlantVariety>{

    private final AddPlantTypeDataModel model;
    private final ListView varityListView;

    public VarietyListChangeAdapter(AddPlantTypeDataModel model, ListView varityListView) {
        this.model = model;
        this.varityListView = varityListView;
    }

    @Override
    public void onChanged(Change<? extends PlantVariety> c) {
        varityListView.setItems(model.getVarieties());
    }
}
