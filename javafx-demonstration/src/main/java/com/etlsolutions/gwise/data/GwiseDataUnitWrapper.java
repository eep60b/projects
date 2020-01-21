package com.etlsolutions.gwise.data;

import com.etlsolutions.javafx.data.*;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseDataUnitWrapper extends DoubleValueWrapper {

    private final ValueWrapper<String> titleWrapper;
    private final ValueWrapper<String> informationWrapper;
    private final ObservableListWrapperA<ImageLink> imageLinks;
    private final ValueWrapper<ImageLink> selectedImageLinkWrapper;
    private final ValueWrapper<String> logoPathWrapper;
    
    public GwiseDataUnitWrapper(String title, String information, List<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath) {
        
        titleWrapper = new ValueWrapper<>(title);
        informationWrapper = new ValueWrapper<>(information);
        this.imageLinks = new ObservableListWrapperA<>(imageLinks);
        selectedImageLinkWrapper = new ValueWrapper<>(selectedImgLinkIndex);
        logoPathWrapper = new ValueWrapper<>(logoPath);
    }

    public GwiseDataUnitWrapper(GwiseDataUnit dataUnit) {        
        this(dataUnit.getTitle(), dataUnit.getInformation(), dataUnit.getImageLinks(), dataUnit.getImageLinks().isEmpty() ? null : dataUnit.getImageLinks().get(dataUnit.getSelectedImgLinkIndex()), dataUnit.getLogoPath());
    }

    public ValueWrapper<String> getTitleWrapper() {
        return titleWrapper;
    }

    public String getTitle() {
        return titleWrapper.getValue();
    }

    public ValueWrapper<String> getInformationWrapper() {
        return informationWrapper;
    }

    public String getInformation() {
        return informationWrapper.getValue();
    }

    public ObservableListWrapperA<ImageLink> getImageLinks() {
        return imageLinks;
    }

    public ValueWrapper<ImageLink> getSelectedImageLinkWrapper() {
        return selectedImageLinkWrapper;
    }

    public ImageLink getSelectedImageLink() {
        return selectedImageLinkWrapper.getValue();
    }

    public ValueWrapper<String> getLogoPathWrapper() {
        return logoPathWrapper;
    }

    public String getLogoPath() {
        return logoPathWrapper.getValue();
    }

    public int getSelectedImgLinkIndex() {
        return imageLinks.isEmpty() ? 0 : imageLinks.indexOf(getSelectedImageLink());
    }
}
