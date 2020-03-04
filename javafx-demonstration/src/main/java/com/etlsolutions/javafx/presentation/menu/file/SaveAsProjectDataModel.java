package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.Closable;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.gwise.system.ProjectConfiguration;
import com.etlsolutions.gwise.system.ProjectManager;
import java.io.File;

/**
 *
 * @author zc
 */
public class SaveAsProjectDataModel implements Validatable, Savable, FXMLActionDataModel, Closable {

    private final ValueWrapper<String> nameValueWrapper;
    private final ValueWrapper<String> pathValueWrapper;

    public SaveAsProjectDataModel() {
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

    @Override
    public void save() {
        
        ProjectConfiguration cf = ProjectManager.getInstance().getConfiguration();
        cf.setName(nameValueWrapper.getValue());
        cf.setParentPath(pathValueWrapper.getValue());
        ProjectManager.getInstance().saveProject();
        close();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/file/SaveAsProjectDialigFXML.fxml";
    }

    @Override
    public void close() {
        nameValueWrapper.removePropertyChangeListeners();
        pathValueWrapper.removePropertyChangeListeners();
        nameValueWrapper.setValue("");
        pathValueWrapper.setValue("");
    }
}
