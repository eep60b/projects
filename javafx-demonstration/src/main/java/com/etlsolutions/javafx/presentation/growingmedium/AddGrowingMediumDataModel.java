package com.etlsolutions.javafx.presentation.growingmedium;

import com.etlsolutions.javafx.data.other.GrowingMediumFactory;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingMediumDataModel extends AbstractGrowingMediumDataModel {



    public AddGrowingMediumDataModel() {
       super(32, 32, 16, 20, 0, 20, 6.8, false);
                
    }

    @Override
    public void save() {
        
        set(GrowingMediumFactory.getInstance().createGrowingMedium(commonValueWrapper, specialValueWrapper));
        ProjectManager.getInstance().getContents().getGrowingMediums().add(get());
    }
}
