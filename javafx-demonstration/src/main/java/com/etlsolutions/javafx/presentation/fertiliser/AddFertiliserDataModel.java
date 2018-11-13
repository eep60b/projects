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
 
        item = FertiliserFactory.getInstance().createFertiliser(title, information, imageLinks, selectedImageLink, logoPath, valueWrapper, partModel.getItemPartValueWrapper());
        ProjectManager.getInstance().getContents().getFertilisers().add(item);
    }
    
}
