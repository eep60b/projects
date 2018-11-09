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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
