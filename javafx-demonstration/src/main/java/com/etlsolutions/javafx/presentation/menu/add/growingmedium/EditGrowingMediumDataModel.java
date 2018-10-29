package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.GrowingMedium;

/**
 *
 * @author zc
 */
public class EditGrowingMediumDataModel extends AbstractGrowingMediumDataModel {

    public EditGrowingMediumDataModel(GrowingMedium growingMedium) {
        super(growingMedium.getSandPercentage(),
                growingMedium.getSiltPercentage(),
                growingMedium.getClayPercentage(),
                growingMedium.getOrganicPercentage(),
                growingMedium.getStonepaencentage(),
                growingMedium.getWaterStoragePercentage(),
                growingMedium.getPh());
        this.growingMedium = growingMedium;
    }

    @Override
    public void save() {

        growingMedium.setSandPercentage(sandPercentage);
        growingMedium.setSiltPercentage(siltPercentage);
        growingMedium.setClayPercentage(clayPercentage);
        growingMedium.setOrganicPercentage(organicPercentage);
        growingMedium.setStonepaencentage(stonePercentage);
        growingMedium.setWaterStoragePercentage(waterStoragePercentage);
        growingMedium.setPh(ph);
    }
}
