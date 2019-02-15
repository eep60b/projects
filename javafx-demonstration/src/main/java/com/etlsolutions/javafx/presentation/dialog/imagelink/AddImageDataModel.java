package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.javafx.data.ImageLinkGenerator;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.Savable;
import java.io.File;

/**
 *
 * @author zc
 */
public class AddImageDataModel implements InformationDataModel, FXMLActionDataModel, Savable, Validatable {

    public static final String IMAGE_FILE_LINK_PROPERTY = "com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel.IMAGE_FILE_LINK_PROPERTY";

    private final ValueWrapper<String> imageFileLinkValueWrapper;
    private final ValueWrapper<String> informationValueWrapper;

    private final DataUnitFXMLDataModel parentModel;

    public AddImageDataModel(DataUnitFXMLDataModel parentModel) {
        imageFileLinkValueWrapper = new ValueWrapper<>("");
        informationValueWrapper = new ValueWrapper<>("");
        this.parentModel = parentModel;
    }

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
    public void save() {
        parentModel.getImageLinks().add(ImageLinkGenerator.getInstance().generateImageLink(imageFileLinkValueWrapper.getValue(), informationValueWrapper.getValue()));
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
