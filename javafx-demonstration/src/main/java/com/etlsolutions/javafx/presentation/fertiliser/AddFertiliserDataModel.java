package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.javafx.data.other.SolidFertiliser;
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
        switch (get().getType()) {
            case LIQUID:
                ProjectManager.getInstance().getContents().getLiquidFertilisers().add((LiquidFertiliser) get());
            case SOLID:
                ProjectManager.getInstance().getContents().getFertilisers().add((SolidFertiliser) get());
        }

    }
}
