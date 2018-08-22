package com.etlsolutions.javafx.data.log;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class Reference extends Log {

    @JsonIgnore
    public static final String PATH_PROPERTY = "com.etlsolutions.javafx.data.log.Reference.PATH_PROPERTY";
    
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        String oldValue = this.path;
        this.path = path;
        fireChange(PATH_PROPERTY, oldValue, this.path);
    }
}
