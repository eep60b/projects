package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 * The DataUnitFXMLDataModel class is designed to button action to start a
 * dialog with title field, information text area, images and OK and Cancel
 * buttons.To use it:
 *
 * 1. Create a empty FXML file with controller which extends
 * DataUnitFXMLController.
 *
 * 2. Create a data model class extents this class.
 *
 * 3. Add a bundle entry to com.etlsolutions.javafx.presentation.ActionEvent
 *
 * @author zc
 * @param <D>
 */
public abstract class DataUnitFXMLDataModel<D extends DataUnit> implements TitleDataModel, InformationDataModel, Savable, FXMLActionDataModel, Validatable, Removable, Getable<D> {

    public static final String LIST_CHANGE_PROPERTY = DataUnitFXMLDataModel.class.getName() + "LIST_CHANGE_PROPERTY ";
    public static final RemoveEventId SELECTED_IMAGE_LINK_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.selectedImageLink", "Selected Image");

    protected final DataUnitValueWrapper commonValueWrapper;
    private D dataUnit;

    protected final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DataUnitFXMLDataModel(D dataUnit) {
        this(dataUnit.getTitle(), dataUnit.getInformation(), dataUnit.getImageLinks(),
                dataUnit.getImageLinks().isEmpty() ? null : dataUnit.getImageLinks().get(dataUnit.getSelectedImgLinkIndex()), dataUnit.getLogoPath());
    }

    public DataUnitFXMLDataModel() {
        this("", "", new ObservableListWrapperA<ImageLink>(), null, "");
    }

    public DataUnitFXMLDataModel(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImageLink, String logoPath) {
        
        commonValueWrapper = new DataUnitValueWrapper(title, information, imageLinks, selectedImageLink, logoPath);
    }

    @Override
    public ValueWrapper<String> getTitleValueWrapper() {
        return commonValueWrapper.getTitleWrapper();
    }

    @Override
    public ValueWrapper<String> getInformationValueWrapper() {
        return commonValueWrapper.getInformationWrapper();
    }

    public ObservableListWrapperA<ImageLink> getImageLinks() {
        return commonValueWrapper.getImageLinks();
    }

    public ValueWrapper<ImageLink> getSelectedImageLinkWrapper() {
        return commonValueWrapper.getSelectedImageLinkWrapper();
    }

    public ValueWrapper<String> getLogoPathValueWrapper() {
        return commonValueWrapper.getLogoPathWrapper();
    }

    public int getSelectedImgLinkIndex() {
        return commonValueWrapper.getSelectedImgLinkIndex();
    }

    @Override
    public void remove(RemoveEventId id) {

        ObservableListWrapperA<ImageLink> imageLinks = getImageLinks();

        if (Objects.equals(id, SELECTED_IMAGE_LINK_REMOVE_EVENT_ID)) {
            int index = imageLinks.indexOf(getSelectedImageLinkWrapper().getValue());
            imageLinks.remove(index);
            getSelectedImageLinkWrapper().setValue(imageLinks.isEmpty() ? null : imageLinks.get(index == imageLinks.size() ? index - 1 : index));
        }
    }

    @Override
    public boolean isInvalid() {
        String title = commonValueWrapper.getTitleWrapper().getValue();
        return title == null || title.trim().isEmpty();
    }

    @Override
    public String getErrorMessage() {

        if (isInvalid()) {
            return "Please enter title.";
        }
        return "";
    }

    @Override
    public final D get() {
        return dataUnit;
    }

    public final void set(D dataUnit) {
        this.dataUnit = dataUnit;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }

    public boolean hasListeners(String propertyName) {
        return support.hasListeners(propertyName);
    }
}
