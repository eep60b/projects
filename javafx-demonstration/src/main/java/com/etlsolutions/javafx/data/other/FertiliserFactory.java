package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.DataUnitCommonValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.TypedItem;

/**
 *
 * @author Zhipeng
 */
public class FertiliserFactory {

    public static final FertiliserFactory INSTANCE = new FertiliserFactory();
    
    private FertiliserFactory() {
    }
    
    public static FertiliserFactory getInstance() {
        return new FertiliserFactory();
    }  
    
    public Fertiliser getDefaultFertiliser() {
        return new SolidFertiliser();
    }
    
    public FertiliserValueWrapper getDefaultFertiliserValueWrapper(FertiliserType fertiliserType) {
        return new FertiliserValueWrapper(fertiliserType, "Unspecified", 0, "", 7.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7.0, 0, 7.0, 7.0, 0, 0, 0, 0, 0, 0);
    }
    
    public LiquidFertiliser getDefaultLiquidFertiliser() {
        return new LiquidFertiliser();
    }
    
    public ObservableListWrapperA<String> getDefaultFertiliserUoms() {
        return new ObservableListWrapperA<>("g", "kg", "litre", "ml", "ounce", "pound", "gallon");
    }

    public LiquidFertiliserSpecialValueWrapper getDefaultLiquidFertiliserValueWrapper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SolidFertiliserSpecialValueWrapper getDefaultSolidFertiliserValueWrapper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Fertiliser createFertiliser(DataUnitCommonValueWrapper commonValueWrapper, FertiliserValueWrapper valueWrapper, TypedItem itemPartValueWrapper) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
