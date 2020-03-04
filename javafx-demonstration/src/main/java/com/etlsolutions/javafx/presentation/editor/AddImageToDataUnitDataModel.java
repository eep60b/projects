package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.dialog.imagelink.*;
import com.etlsolutions.javafx.data.ImageLinkGenerator;
import com.etlsolutions.gwise.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddImageToDataUnitDataModel extends AbstractAddImageDataModel {

    @Override
    public void save() {
        ProjectManager.getInstance().getSelectedDataUnitValueWrapper().getValue().getImageLinks().add(ImageLinkGenerator.getInstance().generateImageLink(getImageFileLinkValueWrapper().getValue(), getInformationValueWrapper().getValue()));
    }
}
