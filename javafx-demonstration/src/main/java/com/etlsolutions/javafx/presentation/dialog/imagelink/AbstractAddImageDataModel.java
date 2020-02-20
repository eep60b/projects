package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.Savable;
import java.io.File;

/**
 *
 * @author zc
 */
public abstract class AbstractAddImageDataModel implements InformationDataModel, FXMLActionDataModel, Savable, Validatable {

    public static final String IMAGE_FILE_LINK_PROPERTY = "com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel.IMAGE_FILE_LINK_PROPERTY";

    private final ValueWrapper<String> imageFileLinkValueWrapper = new ValueWrapper<>("");
    private final ValueWrapper<String> informationValueWrapper = new ValueWrapper<>("");

    public ValueWrapper<String> getImageFileLinkValueWrapper() {
        return imageFileLinkValueWrapper;
    }
    
    @Override
    public ValueWrapper<String> getInformationValueWrapper() {
        return informationValueWrapper;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/imagelink/AddImageLinkDialogFXML.fxml";
    }

    @Override
    public boolean isInvalid() {
        String link = imageFileLinkValueWrapper.getValue();
        return link == null || link.trim().isEmpty() || !new File(link).isFile();
    }

    @Override
    public String getErrorMessage() {

        if (isInvalid()) {
            return "Invalid image link.";
        }
        return "";
    }
}
