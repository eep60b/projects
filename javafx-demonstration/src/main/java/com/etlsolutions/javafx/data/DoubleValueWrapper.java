package com.etlsolutions.javafx.data;

/**
 *
 * @author Zhipeng
 */
public class DoubleValueWrapper {
    
    
    protected final ValueWrapper<String> getWrapper(double value) {
        return new ValueWrapper<>(String.valueOf(value));
    }
    
    protected final double getValue(ValueWrapper<String> wrapper) {
        return Double.parseDouble(wrapper.getValue());
    }
}