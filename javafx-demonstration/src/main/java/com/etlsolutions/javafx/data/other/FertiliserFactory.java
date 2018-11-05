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
    
    public ObservableListWrapperA<String> getDefaultFertiliserUoms() {
        return new ObservableListWrapperA<>("g", "kg", "litre", "ml", "ounce", "pound", "gallon");
    }
}
