package com.etlsolutions.javafx.presentation.dialog.fertiliser;

import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.gwise.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.javafx.data.other.SolidFertiliser;
import com.etlsolutions.gwise.system.ProjectManager;

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

        set(FertiliserFactory.getInstance().createFertiliser(getValueWrapper(), partModel.getItemPartValueWrapper()));
        switch (getItem().getType()) {
            case LIQUID:
                ProjectManager.getInstance().getContents().getLiquidFertilisers().add((LiquidFertiliser) getItem());
            case SOLID:
                ProjectManager.getInstance().getContents().getFertilisers().add((SolidFertiliser) getItem());
        }

    }
}
