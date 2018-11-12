package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.ObservableListWrapperA;

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

}
