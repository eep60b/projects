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
        item.setTitle(title);
        item.setInformation(information);
        item.getImageLinks().clear();
        item.getImageLinks().addAll(imageLinks);
        item.setLatinName(latinName);
        item.getAliases().clear();
        item.getAliases().addAll(aliases);
    }
}
