package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.other.GrowingMedium;

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
        this.item = growingMedium;
    }

    @Override
    public void save() {

        item.setSandPercentage(sandPercentage);
        item.setSiltPercentage(siltPercentage);
        item.setClayPercentage(clayPercentage);
        item.setOrganicPercentage(organicPercentage);
        item.setStonepaencentage(stonePercentage);
        item.setWaterStoragePercentage(waterStoragePercentage);
        item.setPh(ph);
    }
}
