package com.etlsolutions.javafx.data.area.subarea.location;

import java.util.Objects;

/**
 *
 * @author zc
 */
public class ContainerShape {
    
    private String title;

    public ContainerShape() {
    }

    public ContainerShape(String title) {
        this.title = title;
    }
        
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.title);
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
        final ContainerShape other = (ContainerShape) obj;
        return Objects.equals(this.title == null ? null : this.title.toLowerCase(), other.title == null ? null : other.title.toLowerCase());
    }  
}
