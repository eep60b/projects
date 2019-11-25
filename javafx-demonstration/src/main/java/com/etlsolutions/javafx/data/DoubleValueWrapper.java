package com.etlsolutions.javafx.data;

/**
 * The DoubleValueWrapper class is a super class for all data unit value
 * wrappers.
 *
 * @author Zhipeng
 */
public class DoubleValueWrapper {

    /**
     * Create a string wrapper for the given value. This method is used for
     * children classes to create ValueWrapper for its fields.
     *
     * @param value - The specified value
     * @return the newly created wrapper.
     */
    protected final ValueWrapper<String> getWrapper(double value) {
        return new ValueWrapper<>(String.valueOf(value));
    }

    /**
     * Get a double value from the given string value wrapper.
     *
     * @param wrapper - The specified string value wrapper.
     * @return the double value.
     * @throws NumberFormatException if the string in the wrapper cannot be
     * parsed into a double value.
     */
    protected final double getValue(ValueWrapper<String> wrapper) {
        return Double.parseDouble(wrapper.getValue());
    }
}
