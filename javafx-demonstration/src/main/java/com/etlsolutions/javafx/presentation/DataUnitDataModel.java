package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public abstract class DataUnitDataModel implements TitleDataModel, InformationDataModel {

    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMG_TITLE_PROPERTY";
    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMG_INFORMATION_PROPERTY";
    public static final String IMAGE_LINKS_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMAGE_LINKS_PROPERTY";
    public static final String SELECTED_IMAGE_LINK_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.SELECTED_IMAGE_LINK_PROPERTY";
    public static final String LOGO_PATH_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.LOGO_PATH_PROPERTY";

    private String title;
    private String information;
    private List<ImageLink> imageLinks;
    private ImageLink selectedImageLink;
    private String logoPath;
    protected boolean valid;
    protected String errorMessage;
    
    protected final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DataUnitDataModel() {
        this.imageLinks = new ArrayList<>();
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

    public List<ImageLink> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<ImageLink> imageLinks) {
        this.imageLinks = new ArrayList<>(imageLinks);
        support.firePropertyChange(IMAGE_LINKS_PROPERTY, true, false);
    }

    public boolean addImageLink(ImageLink imageLink) {

        boolean added = imageLinks.add(imageLink);
        support.firePropertyChange(IMAGE_LINKS_PROPERTY, false, added);
        if (added) {
            setSelectedImageLink(imageLink);
        }
        return added;
    }

    public ImageLink getSelectedImageLink() {
        return selectedImageLink;
    }

    public void setSelectedImageLink(ImageLink selectedImageLink) {

        ImageLink oldValue = this.selectedImageLink;
        this.selectedImageLink = selectedImageLink;
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
        ImageLink oldValue = this.selectedImageLink;
        selectedImageLink = imageLinks.get(imageLinks.indexOf(selectedImageLink) + 1);
        support.firePropertyChange(SELECTED_IMAGE_LINK_PROPERTY, oldValue, this.selectedImageLink);
    }

    public void removeSelectedImageLink() {
        int index = imageLinks.indexOf(selectedImageLink);
        boolean removed = imageLinks.remove(selectedImageLink);
        support.firePropertyChange(IMAGE_LINKS_PROPERTY, false, removed);
        setSelectedImageLink(imageLinks.isEmpty() ? null : imageLinks.get(index == imageLinks.size() ? index - 1 : index));
    }

    public void setSelectedImageLinkToFirst() {
        ImageLink oldValue = this.selectedImageLink;
        selectedImageLink = imageLinks.get(0);
        support.firePropertyChange(SELECTED_IMAGE_LINK_PROPERTY, oldValue, this.selectedImageLink);
    }

    public void setSelectedImageLinkToLast() {
        ImageLink oldValue = this.selectedImageLink;
        selectedImageLink = imageLinks.get(imageLinks.size() - 1);
        support.firePropertyChange(SELECTED_IMAGE_LINK_PROPERTY, oldValue, this.selectedImageLink);
    }

    public void decrementSelectedImageLinkIndex() {
        ImageLink oldValue = this.selectedImageLink;
        selectedImageLink = imageLinks.get(imageLinks.indexOf(selectedImageLink) - 1);
        support.firePropertyChange(SELECTED_IMAGE_LINK_PROPERTY, oldValue, this.selectedImageLink);
    }

    public boolean isValid() {
        return valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }    
}
