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
        dataUnit.setTitle(title);
        dataUnit.setInformation(information);
        dataUnit.getImageLinks().clear();
        dataUnit.getImageLinks().addAll(imageLinks);
        dataUnit.setLatinName(latinName);
        dataUnit.getAliases().clear();
        dataUnit.getAliases().addAll(aliases);
    }
}
