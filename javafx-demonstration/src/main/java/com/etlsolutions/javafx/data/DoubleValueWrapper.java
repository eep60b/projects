package com.etlsolutions.javafx.data;

/**
 *
 * @author Zhipeng
 */
public class DoubleValueWrapper {
    
    
    protected ValueWrapper<String> getWrapper(double value) {
        return new ValueWrapper<>(String.valueOf(value));
    }
    
    protected double getValue(ValueWrapper<String> wrapper) {
        return Double.parseDouble(wrapper.getValue());
    }
}