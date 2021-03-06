package com.etlsolutions.javafx.data.other;

import com.etlsolutions.gwise.data.other.FertiliserType;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
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
    
    public  Fertiliser getDefaultFertiliser() {
        return new SolidFertiliser();
    }
    
    public FertiliserValueWrapper getDefaultFertiliserValueWrapper(FertiliserType fertiliserType) {
        return new FertiliserValueWrapper("untitled", "", new ObservableListWrapperA<ImageLink>(), null, "",  fertiliserType, "Unspecified", 0, "", 7.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7.0, 0, 7.0, 7.0, 0, 0, 0, 0, 0, 0);
    }
    
    public LiquidFertiliser getDefaultLiquidFertiliser() {
        return new LiquidFertiliser();
    }
    
    public ObservableListWrapperA<String> getDefaultFertiliserUoms() {
        return new ObservableListWrapperA<>("g", "kg", "litre", "ml", "ounce", "pound", "gallon");
    }

    public LiquidFertiliserSpecialValueWrapper getDefaultLiquidFertiliserValueWrapper() {
        return new LiquidFertiliserSpecialValueWrapper(true, 0, "ml/L");
    }

    public SolidFertiliserSpecialValueWrapper getDefaultSolidFertiliserValueWrapper() {
        return new SolidFertiliserSpecialValueWrapper(0, "g/ml");
    }

    public Fertiliser createFertiliser(FertiliserValueWrapper valueWrapper, TypedItem itemPartValueWrapper) {
        return getDefaultFertiliser();
    }

    public ObservableListWrapperA<Fertiliser> getDefaultFertilisers() {
        return new ObservableListWrapperA<>(getDefaultFertiliser());
    }

    public ObservableListWrapperA<LiquidFertiliser> getDefaultLiquidFertilisers() {
        return new ObservableListWrapperA<>(new LiquidFertiliser());
    }
}
