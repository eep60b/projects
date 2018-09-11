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
public class DataUnitDataModel implements TitleDataModel, InformationDataModel {

    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMG_TITLE_PROPERTY";
    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMG_INFORMATION_PROPERTY";
    public static final String IMAGE_LINKS_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.IMAGE_LINKS_PROPERTY";
    public static final String SELECTED_IMAGE_LINK_INDEX_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.SELECTED_IMAGE_LINK_INDEX_PROPERTY";
    public static final String LOGO_PATH_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.LOGO_PATH_PROPERTY";

    private String title;
    private String information;
    private List<ImageLink> imageLinks;
    private int selectedImageLinkIndex;
    private String logoPath;
    
    protected final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DataUnitDataModel() {
        this.imageLinks = new ArrayList<>();
    }

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
        return added;
    }

    public boolean removeImageLink(ImageLink imageLink) {
        
        boolean removed = imageLinks.remove(imageLink);
        support.firePropertyChange(IMAGE_LINKS_PROPERTY, false, removed);
        return removed;
    }
    
    public int getSelectedImageLinkIndex() {
        return selectedImageLinkIndex;
    }

    public void setSelectedImageLinkIndex(int selectedImageLinkIndex) {
        
        int oldValue = this.selectedImageLinkIndex;
        this.selectedImageLinkIndex = selectedImageLinkIndex;
        support.firePropertyChange(SELECTED_IMAGE_LINK_INDEX_PROPERTY, oldValue, this.selectedImageLinkIndex);
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
}
