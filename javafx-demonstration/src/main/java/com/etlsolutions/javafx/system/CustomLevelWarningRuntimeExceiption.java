package com.etlsolutions.javafx.system;

/**
 * The CustomLevelErrorRuntimeExceiption class is used to convert other exceptions such as IOException into a RuntimeExeption to show a message for the user. The message should be user friendly.
 *
 * @author zc
 */
public class CustomLevelWarningRuntimeExceiption extends RuntimeException {

    public CustomLevelWarningRuntimeExceiption(String message) {
        super(message);
    }

    public CustomLevelWarningRuntimeExceiption(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomLevelWarningRuntimeExceiption(Throwable cause) {
        super(cause);
    }

}
