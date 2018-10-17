package com.etlsolutions.javafx.presentation;

import java.util.Objects;

/**
 *
 * @author zc
 */
public class RemoveEventId {
    
    private final String key;
    private String itemName;

    public RemoveEventId(String key, String itemName) {
        this.key = key;
        this.itemName = itemName;
    }

    public String getKey() {
        return key;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RemoveEventId other = (RemoveEventId) obj;
        return Objects.equals(this.key, other.key);
    }
}
