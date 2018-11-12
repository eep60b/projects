package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.FertiliserFactory;

/**
 *
 * @author zc
 */
public class AddFertiliserDataModel extends AbstractFertiliserDataModel {

    public AddFertiliserDataModel() {
        super(FertiliserFactory.getInstance().getDefaultFertiliserValueWrapper());
    }

    @Override
    public void save() {
        item = FertiliserFactory.getInstance().createFertiliser(title, information, imageLinks, selectedImageLink, logoPath, valueWrapper, partModel.getItemPartValueWrapper());
        
        
    }
    
}
