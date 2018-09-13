package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 */
public interface Validatable {
    
    boolean isValid();
    
    String getErrorMessage();
}
