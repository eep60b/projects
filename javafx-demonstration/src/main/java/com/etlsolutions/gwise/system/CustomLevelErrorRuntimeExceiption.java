package com.etlsolutions.gwise.system;

/**
 * The CustomLevelErrorRuntimeExceiption class is used to convert other exceptions such as IOException into a RuntimeExeption to show a message for the user. The message should be user friendly.
 *
 * @author zc
 */
public class CustomLevelErrorRuntimeExceiption extends RuntimeException {

    public CustomLevelErrorRuntimeExceiption(String message) {
        super(message);
    }

    public CustomLevelErrorRuntimeExceiption(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomLevelErrorRuntimeExceiption(Throwable cause) {
        super(cause);
    }

}
