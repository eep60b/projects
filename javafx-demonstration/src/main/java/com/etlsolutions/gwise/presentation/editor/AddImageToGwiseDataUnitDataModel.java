package com.etlsolutions.gwise.presentation.editor;

import com.etlsolutions.javafx.presentation.dialog.imagelink.*;
import com.etlsolutions.javafx.data.ImageLinkGenerator;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddImageToGwiseDataUnitDataModel extends AbstractAddImageDataModel {

    @Override
    public void save() {
        ProjectManager.getInstance().getSelectedGwiseDataUnitValueWrapper().getValue().getImageLinks().add(ImageLinkGenerator.getInstance().generateImageLink(getImageFileLinkValueWrapper().getValue(), getInformationValueWrapper().getValue()));
    }
}
