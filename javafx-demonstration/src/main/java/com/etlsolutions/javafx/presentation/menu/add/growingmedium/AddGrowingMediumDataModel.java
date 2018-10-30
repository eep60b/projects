package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.other.GrowingMediumFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingMediumDataModel extends AbstractGrowingMediumDataModel {



    public AddGrowingMediumDataModel() {
       super(32, 32, 16, 20, 0, 20, 6.8);
                
    }

    @Override
    public void save() {
        
        growingMedium = GrowingMediumFactory.getInstance().createGrowingMedium(title, information, imageLinks, 0, title, 
                new double[]{sandPercentage, siltPercentage, clayPercentage, organicPercentage, stonePercentage, waterStoragePercentage, ph}, true);
        ProjectManager.getInstance().getProject().getGrowingMediums().add(growingMedium);
    }
}
