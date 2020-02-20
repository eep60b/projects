package com.etlsolutions.gwise.presentation.dialog.imagelink;

import com.etlsolutions.gwise.presentation.GwiseDataUnitFXMLDataModel;
import com.etlsolutions.javafx.data.ImageLinkGenerator;
import com.etlsolutions.javafx.presentation.dialog.imagelink.AbstractAddImageDataModel;

/**
 *
 * @author zc
 */
public class GwiseAddImageToFXMLDataModel extends AbstractAddImageDataModel {

    private final GwiseDataUnitFXMLDataModel parentModel;

    public GwiseAddImageToFXMLDataModel(GwiseDataUnitFXMLDataModel parentModel) {
        this.parentModel = parentModel;
    }

    @Override
    public void save() {
        parentModel.getImageLinks().add(ImageLinkGenerator.getInstance().generateImageLink(getImageFileLinkValueWrapper().getValue(), getInformationValueWrapper().getValue()));
    }
}
