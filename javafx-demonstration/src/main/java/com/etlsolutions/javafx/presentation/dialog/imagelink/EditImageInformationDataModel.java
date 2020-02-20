package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Savable;

/**
 *
 * @author zc
 */
public class EditImageInformationDataModel implements InformationDataModel, FXMLActionDataModel, Savable {

    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.data.ImageLink.EditImageInformationDataModel.INFORMATION_PROPERTY";
    
    private final ImageLink imageLink;
    private final ValueWrapper<String> informationValueWrapper;
            
    public EditImageInformationDataModel(ImageLink imageLink) {
        this.imageLink = imageLink;
        informationValueWrapper = new ValueWrapper<>(imageLink == null ? "" : imageLink.getInformation());
    }

    public String getImageLink() {
        return imageLink.getLink();
    }

    @Override
    public ValueWrapper<String> getInformationValueWrapper() {
        return informationValueWrapper;
    }   

    @Override
    public void save() {
        imageLink.setInformation(informationValueWrapper.getValue());      
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/imagelink/EditImageInformationDialogFXML.fxml";
    }
}
