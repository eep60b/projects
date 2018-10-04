package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.beans.PropertyChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public abstract class DataUnitDataModel implements TitleDataModel, InformationDataModel, Savable {

    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMG_TITLE_PROPERTY";
    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMG_INFORMATION_PROPERTY";
    public static final String SELECTED_IMAGE_LINK_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.SELECTED_IMAGE_LINK_PROPERTY";
    public static final String LOGO_PATH_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.LOGO_PATH_PROPERTY";

    protected final ObservableList<ImageLink> imageLinks;    
    protected String title;
    protected String information;
    private ImageLink selectedImageLink;
    private String logoPath;
    protected boolean valid;
    protected String errorMessage;
    private boolean firstImage;
    private boolean lastImage;
    
    protected final DataUnitPropertyChangeSupport support = new DataUnitPropertyChangeSupport(this);

    public DataUnitDataModel() {
        this.imageLinks = new ObservableListWrapperA<>();
    }

    protected abstract void validate();
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {

        String oldValue = this.title;
        this.title = title;
        support.firePropertyChange(TITLE_PROPERTY, oldValue, this.title);
    }

    @Override
    public void setInformation(String information) {
        String oldValue = this.information;
        this.information = information;
        support.firePropertyChange(INFORMATION_PROPERTY, oldValue, this.information);
    }

    @Override
    public String getInformation() {
        return information;
    }

    public ObservableList<ImageLink> getImageLinks() {
        return imageLinks;
    }


    public ImageLink getSelectedImageLink() {
        return selectedImageLink;
    }

    public void setSelectedImageLink(ImageLink selectedImageLink) {

        ImageLink oldValue = this.selectedImageLink;
        this.selectedImageLink = selectedImageLink;
        firstImage = selectedImageLink == null || selectedImageLink == imageLinks.get(0);
        lastImage = selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1);
        support.firePropertyChange(SELECTED_IMAGE_LINK_PROPERTY, oldValue, this.selectedImageLink);
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {

        String oldValue = this.logoPath;
        this.logoPath = logoPath;
        support.firePropertyChange(LOGO_PATH_PROPERTY, oldValue, this.logoPath);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void incrementSelectedImageLinkIndex() {
        setSelectedImageLink(imageLinks.get(imageLinks.indexOf(selectedImageLink) + 1));
    }

    public void removeSelectedImageLink() {
        int index = imageLinks.indexOf(selectedImageLink);
        imageLinks.remove(selectedImageLink);
        setSelectedImageLink(imageLinks.isEmpty() ? null : imageLinks.get(index == imageLinks.size() ? index - 1 : index));
    }

    public void setSelectedImageLinkToFirst() {
        setSelectedImageLink(imageLinks.get(0));
    }

    public void setSelectedImageLinkToLast() {
        setSelectedImageLink(imageLinks.get(imageLinks.size() - 1));
    }

    public void decrementSelectedImageLinkIndex() {
        setSelectedImageLink(imageLinks.get(imageLinks.indexOf(selectedImageLink) - 1));
    }

    public boolean isValid() {
        return valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }    

    public boolean isFirstImage() {
        return firstImage;
    }

    public boolean isLastImage() {
        return lastImage;
    }
}
