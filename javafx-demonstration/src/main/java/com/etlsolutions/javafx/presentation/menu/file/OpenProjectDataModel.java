package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.Closable;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.system.ProjectManager;
import java.io.File;

/**
 *
 * @author zc
 */
public class OpenProjectDataModel implements Validatable, Savable, FXMLActionDataModel, Closable {

    private final ValueWrapper<String> pathValueWrapper;

    public OpenProjectDataModel() {
        pathValueWrapper = new ValueWrapper<>("");
    }

    public ValueWrapper<String> getPathValueWrapper() {
        return pathValueWrapper;
    }

    @Override
    public boolean isInvalid() {
        String path = pathValueWrapper.getValue();
        return !ProjectManager.getInstance().isValidProject(path) ;
    }

    @Override
    public String getErrorMessage() {


        String path = pathValueWrapper.getValue();

        if(path == null || path.trim().isEmpty()) {
            return "Please entry the project location.";
        }

        if (!new File(path).isDirectory()) {
            return "The location has already been used.";
        }
        
        if(!ProjectManager.getInstance().isValidProject(path)) {
            return "This is not a valid gardenwise project.";
        }

        return "";
    }

    @Override
    public void save() {
        ProjectManager.getInstance().loadProject(pathValueWrapper.getValue());
        close();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/file/OpenProjectFXML.fxml";
    }

    @Override
    public void close() {
        pathValueWrapper.removePropertyChangeListeners();
        pathValueWrapper.setValue("");
    }
}
