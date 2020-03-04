package com.etlsolutions.gwise.system;

import com.etlsolutions.gwise.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class DefaultListFactory {

    private static final DefaultListFactory INSTANCE = new DefaultListFactory();

    private DefaultListFactory() {

    }

    public static DefaultListFactory getInstance() {
        return INSTANCE;
    }

    public ObservableListWrapperA<String> getDefaultSolidFertiliserDensityUoms() {
        
        return new ObservableListWrapperA<>("g/ml", "kg/l");
    }

    public ObservableListWrapperA<String> getDefaultFertiliserDilusionRatioUoms() {
        return new ObservableListWrapperA<>("ml/L", "mg/L");
    }

}
