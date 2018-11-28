package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddFertiliserDataModel extends AbstractFertiliserDataModel {

    public AddFertiliserDataModel() {
        this(FertiliserType.SOLID);
    }

    public AddFertiliserDataModel(FertiliserType fertiliserType) {
        super(FertiliserFactory.getInstance().getDefaultFertiliserValueWrapper(fertiliserType), fertiliserType);
    }

    @Override
    public void save() {

        set(FertiliserFactory.getInstance().createFertiliser(commonValueWrapper, valueWrapper, partModel.getItemPartValueWrapper()));
        ProjectManager.getInstance().getContents().getFertilisers().add(get());
    }
}
