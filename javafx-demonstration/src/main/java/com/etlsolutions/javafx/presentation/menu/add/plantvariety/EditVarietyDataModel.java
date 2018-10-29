package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.data.plant.PlantVariety;

/**
 *
 * @author zc
 */
public class EditVarietyDataModel extends AbstractVarietyDataModel {


    public EditVarietyDataModel(PlantVariety variety) {
        super(variety);
    }

    @Override
    public void save() {
        variety.setTitle(title);
        variety.setInformation(information);
        variety.getImageLinks().clear();
        variety.getImageLinks().addAll(imageLinks);
        variety.setLatinName(latinName);
        variety.getAliases().clear();
        variety.getAliases().addAll(aliases);
    }
}
