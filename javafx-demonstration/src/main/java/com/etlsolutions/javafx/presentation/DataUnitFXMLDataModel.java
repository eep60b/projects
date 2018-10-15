package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.beans.PropertyChangeListener;
import javafx.collections.ObservableList;

/**
 * The DataUnitFXMLDataModel class is designed to button action to start a
 * dialog with title field, information text area, images and OK and Cancel
 * buttons. To use it:
 *
 * 1. Create a empty FXML file with controller which extends
 * DataUnitFXMLController.
 *
 * 2. Create a data model class extents this class.
 *
 * 3. Add a bundle entry to com.etlsolutions.javafx.presentation.ActionEvent
 *
 * @author zc
 */
public abstract class DataUnitFXMLDataModel implements TitleDataModel, InformationDataModel, Addable, FXMLActionDataModel, Validatable {

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
    private boolean noOrFirstImage;
    private boolean noOrLastImage;

    protected final DataUnitPropertyChangeSupport support = new DataUnitPropertyChangeSupport(this);

    public DataUnitFXMLDataModel() {
        this.imageLinks = new ObservableListWrapperA<>();
        noOrFirstImage = true;
        noOrLastImage = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {

        String oldValue = this.title;
        this.title = title;
        validate();
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
        noOrFirstImage = selectedImageLink == null || selectedImageLink == imageLinks.get(0);
        noOrLastImage = selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1);
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

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isNoOrFirstImage() {
        return noOrFirstImage;
    }

    public boolean isNoOrLastImage() {
        return noOrLastImage;
    }

    protected void validate() {
        valid = title != null && title.trim().isEmpty();
        errorMessage = valid ? "" : "Please enter title.";
    }
}
