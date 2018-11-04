package com.etlsolutions.javafx.data.other;

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
}
