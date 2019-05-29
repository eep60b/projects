package com.etlsolutions.javafx.presentation;

/**
 * The Itemable interface marks a class which there contains an item can be
 * retrieved. The implementation must guarantee the item is NOT null.
 *
 * @param <T> - The item type.
 *
 * @author ZhipengChang
 */
public interface Itemable<T> {

    /**
     * Get the item.
     *
     * @return the item. The item cannot be null.
     */
    T getItem();
}
