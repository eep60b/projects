package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.gwise.data.ImageLinkGenerator;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;

/**
 *
 * @author zc
 */
public class AddImageToFXMLDataModel extends AbstractAddImageDataModel {

    private final DataUnitFXMLDataModel parentModel;

    public AddImageToFXMLDataModel(DataUnitFXMLDataModel parentModel) {
        this.parentModel = parentModel;
    }

    @Override
    public void save() {
        parentModel.getImageLinks().add(ImageLinkGenerator.getInstance().generateImageLink(getImageFileLinkValueWrapper().getValue(), getInformationValueWrapper().getValue()));
    }
}
