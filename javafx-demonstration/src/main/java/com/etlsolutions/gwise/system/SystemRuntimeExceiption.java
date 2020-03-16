package com.etlsolutions.gwise.system;

/**
 * The CustomLevelErrorRuntimeExceiption class is used to convert other exceptions such as IOException into a RuntimeExeption to show a message for the user. The message should be user friendly.
 *
 * @author zc
 */
public class SystemRuntimeExceiption extends RuntimeException {

    public SystemRuntimeExceiption(String message) {
        super(message);
    }

    public SystemRuntimeExceiption(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemRuntimeExceiption(Throwable cause) {
        super(cause);
    }

}
