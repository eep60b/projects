package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.ObservableListWrapperA;

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
    
    public FertiliserValueWrapper getDefaultFertiliserValueWrapper() {
        return new FertiliserValueWrapper(FertiliserType.SOLID, "Unspecified", 0, "", 7.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7.0, 0, 7.0, 7.0, 0, 0, 0, 0, 0, 0);
    }
    
    public LiquidFertiliser getDefaultLiquidFertiliser() {
        return new LiquidFertiliser();
    }
    
    public ObservableListWrapperA<String> getDefaultFertiliserUoms() {
        return new ObservableListWrapperA<>("g", "kg", "litre", "ml", "ounce", "pound", "gallon");
    }

    public LiquidFertiliserDetailValueWrapper getDefaultLiquidFertiliserValueWrapper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SolidFertiliserDetailValueWrapper getDefaultSolidFertiliserValueWrapper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
