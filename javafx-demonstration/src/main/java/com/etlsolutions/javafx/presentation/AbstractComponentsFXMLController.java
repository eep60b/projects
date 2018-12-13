package com.etlsolutions.javafx.presentation;

/**
 * AbstractComponentsFXMLController is an FXML Controller whose data model can
 * be set.
 *
 * @author zc
 * @param <T>
 */
public abstract class AbstractComponentsFXMLController<T> {

    protected T model;

    public abstract void initializeComponents() throws Exception;

    /**
     * Get the data model.
     * @return the data model object.
     */
    public final T getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public final void setModel(T model) {
        this.model = model;
    }
}
