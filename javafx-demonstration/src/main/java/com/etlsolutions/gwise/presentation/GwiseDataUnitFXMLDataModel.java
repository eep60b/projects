package com.etlsolutions.gwise.presentation;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Itemable;
import com.etlsolutions.javafx.presentation.Removable;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.TitleDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
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
public abstract class GwiseDataUnitFXMLDataModel<D extends GwiseDataUnit> implements TitleDataModel, InformationDataModel, Savable, FXMLActionDataModel, Validatable, Removable, Itemable<D> {

    public static final String LIST_CHANGE_PROPERTY = GwiseDataUnitFXMLDataModel.class.getName() + "LIST_CHANGE_PROPERTY ";
    public static final RemoveEventId SELECTED_IMAGE_LINK_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.selectedImageLink", "Selected Image");

    private D dataUnit;

    protected final PropertyChangeSupport support = new PropertyChangeSupport(this);
 
    protected abstract DataUnitValueWrapper getValueWrapper();
    
    @Override
    public ValueWrapper<String> getTitleValueWrapper() {
        return getValueWrapper().getTitleWrapper();
    }

    @Override
    public ValueWrapper<String> getInformationValueWrapper() {
        return getValueWrapper().getInformationWrapper();
    }

    public ObservableListWrapperA<ImageLink> getImageLinks() {
        return getValueWrapper().getImageLinks();
    }

    public ValueWrapper<ImageLink> getSelectedImageLinkWrapper() {
        return getValueWrapper().getSelectedImageLinkWrapper();
    }

    public ValueWrapper<String> getLogoPathValueWrapper() {
        return getValueWrapper().getLogoPathWrapper();
    }

    public int getSelectedImgLinkIndex() {
        return getValueWrapper().getSelectedImgLinkIndex();
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
        String title = getValueWrapper().getTitleWrapper().getValue();
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
    public final D getItem() {
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
