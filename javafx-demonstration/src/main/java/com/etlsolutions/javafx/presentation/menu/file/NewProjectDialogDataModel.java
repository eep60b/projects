package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.Validatable;
import java.io.File;

/**
 *
 * @author zc
 */
public class NewProjectDialogDataModel implements Validatable {

    private final ValueWrapper<String> nameValueWrapper;
    private final ValueWrapper<String> pathValueWrapper;

    public NewProjectDialogDataModel() {
        nameValueWrapper = new ValueWrapper<>("");
        pathValueWrapper = new ValueWrapper<>("");
    }

    public ValueWrapper<String> getNameValueWrapper() {
        return nameValueWrapper;
    }

    public ValueWrapper<String> getPathValueWrapper() {
        return pathValueWrapper;
    }

    @Override
    public boolean isInvalid() {
        String name = nameValueWrapper.getValue();
        String path = pathValueWrapper.getValue();
        return name == null || name.trim().isEmpty() || path == null || path.trim().isEmpty() || new File(path + File.separator + name).exists();
    }

    @Override
    public String getErrorMessage() {

        String name = nameValueWrapper.getValue();
        String path = pathValueWrapper.getValue();
        
        if (name == null || name.trim().isEmpty()) {
            return "Please entry the project name.";
        }

        if (!Character.isLetter(name.trim().charAt(0))) {
            return "The project iname must start with a letter.";
        }

        if(path == null || path.trim().isEmpty()) {
            return "Please entry the project location.";
        }

        if (new File(path + File.separator + name).exists()) {
            return "The location has already been used.";
        }

        return "";
    }
}
