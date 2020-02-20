package com.etlsolutions.javafx.presentation.dialog.growingmedium;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.other.GrowingMediumFactory;
import com.etlsolutions.javafx.data.other.GrowingMediumSpecialValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingMediumDataModel extends AbstractGrowingMediumDataModel {

    public AddGrowingMediumDataModel() {
        super(new GrowingMediumSpecialValueWrapper("Loam", "", new ObservableListWrapperA<ImageLink>(), null, "", 32, 32, 16, 20, 0, 20, 6.8, false));               
    }

    @Override
    public void save() {
        
        set(GrowingMediumFactory.getInstance().createGrowingMedium(specialValueWrapper));
        ProjectManager.getInstance().getContents().getGrowingMediums().add(getItem());
    }
}
