package com.etlsolutions.javafx.data;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class DataUnitValueWrapper extends DoubleValueWrapper {

    private final ValueWrapper<String> titleWrapper;
    private final ValueWrapper<String> informationWrapper;
    private final ObservableListWrapperA<ImageLink> imageLinks;
    private final ValueWrapper<ImageLink> selectedImageLinkWrapper;
    private final ValueWrapper<String> logoPathWrapper;
    
    public DataUnitValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath) {
        
        titleWrapper = new ValueWrapper<>(title);
        informationWrapper = new ValueWrapper<>(information);
        this.imageLinks = new ObservableListWrapperA<>(imageLinks);
        selectedImageLinkWrapper = new ValueWrapper<>(selectedImgLinkIndex);
        logoPathWrapper = new ValueWrapper<>(logoPath);
    }

    public DataUnitValueWrapper(DataUnit dataUnit) {
        
        titleWrapper = new ValueWrapper<>(dataUnit.getTitle());
        informationWrapper = new ValueWrapper<>(dataUnit.getInformation());
        imageLinks = new ObservableListWrapperA<>(dataUnit.getImageLinks());
        selectedImageLinkWrapper = new ValueWrapper<>(imageLinks.isEmpty() ? null : imageLinks.get(0));
        logoPathWrapper = new ValueWrapper<>(dataUnit.getLogoPath());
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
