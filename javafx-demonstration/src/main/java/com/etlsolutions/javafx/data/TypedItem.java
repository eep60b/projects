package com.etlsolutions.javafx.data;

/**
 * The TypedItem interface marks an item which has a type.
 *
 * @author zc
 * @param <T>
 */
public interface TypedItem<T> {

    /**
     * Get the item type.
     *
     * @return the item type.
     */
    T getType();
}
