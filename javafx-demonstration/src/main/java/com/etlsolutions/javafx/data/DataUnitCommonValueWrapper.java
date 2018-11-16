package com.etlsolutions.javafx.data;

/**
 *
 * @author zc
 */
public class DataUnitCommonValueWrapper {

    private final ValueWrapper<String> titleWrapper;
    private final ValueWrapper<String> informationWrapper;
    private final ObservableListWrapperA<ImageLink> imageLinks;
    private final ValueWrapper<ImageLink> selectedImageLinkWrapper;
    private final ValueWrapper<String> logoPathWrapper;

    public DataUnitCommonValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath) {
        this.titleWrapper = new ValueWrapper<>(title);
        this.informationWrapper = new ValueWrapper<>(information);
        this.imageLinks = new ObservableListWrapperA<>(imageLinks);
        this.selectedImageLinkWrapper = new ValueWrapper<>(selectedImgLinkIndex);
        this.logoPathWrapper = new ValueWrapper<>(logoPath);
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

    int getSelectedImgLinkIndex() {
        return imageLinks.isEmpty() ? 0 : imageLinks.indexOf(getSelectedImageLink());
    }
}
