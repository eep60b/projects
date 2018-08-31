package com.etlsolutions.javafx.presentation.menu.file;

import java.io.File;

/**
 *
 * @author zc
 */
public class NewProjectDialogDataModel {
    
    
    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public boolean isValid() {
        return !(name == null || name.trim().isEmpty() || path == null || path.trim().isEmpty() || new File(path + File.separator + name).exists());                   
    }
    
    public String getErrorMessage() {
        
        if(name == null || name.trim().isEmpty()) {
            return "Please entry the project name.";            
        }
        
        if(!Character.isLetter(name.trim().charAt(0))) {
            return "The project iname must start with a letter.";
        }
        
        if(path == null || path.trim().isEmpty()) {
            return "Please entry the project location.";
        }
        
        if(new File(path + File.separator + name).exists()) {
            return "The location has already been used.";
        }
        
        return "";
    }
}
