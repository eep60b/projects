package com.etlsolutions.javafx.data;

import com.etlsolutions.javafx.system.SettingConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;

/**
 * The DataUnit class represents objects which are data units. Keep the
 * implementation as simple as possible so they can be serialised easily.
 *
 * @author zc
 */
public abstract class DataUnit {

    @JsonIgnore
    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.data.DataUnit.TITLE_PROPERTY";
    @JsonIgnore
    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.data.DataUnit.INFORMATION_PROPERTY";
    @JsonIgnore
    public static final String DESCRIPTION_PROPERTY = "com.etlsolutions.javafx.data.DataUnit.DESCRIPTION_PROPERTY";
    @JsonIgnore
    public static final String SELECTED_ING_LINK_INDEX_PROPERTY = "com.etlsolutions.javafx.data.DataUnit.SELECTED_ING_LINK_INDEX_PROPERTY";
    @JsonIgnore
    public static final String LOGO_PATH_PROPERTY = "com.etlsolutions.javafx.data.DataUnit.LOGO_PATH_PROPERTY";

    private int id;
    private String title;
    private String information;
    private ObservableListWrapperA<ImageLink> imageLinks;
    private int selectedImgLinkIndex;
    private String logoPath;

    @JsonIgnore
    protected final DataUnitChangeSupport support = new DataUnitChangeSupport();

    /**
     * The default constructor.
     */
    public DataUnit() {
    }


    protected DataUnit(String title) {
        this.id = DataUnitIdRegistry.getInstance().createNewId();
        this.title = title;
        this.information = "";
        this.imageLinks = new ObservableListWrapperA<>();
    }


    public DataUnit(DataUnitValueWrapper valueWrapper) {
        this(valueWrapper.getTitle());
        this.information = valueWrapper.getInformation();
        this.imageLinks = new ObservableListWrapperA<>(valueWrapper.getImageLinks());
        this.selectedImgLinkIndex = valueWrapper.getSelectedImgLinkIndex();
        this.logoPath = valueWrapper.getLogoPath();
    }

    /**
     * Get the ID for this data unit.
     *
     * @return the ID number.
     * @throws IllegalStateException if the ID has not been set.
     */
    public final int getId() {
        return id;
    }

    /**
     * Set the ID for this data unit. The ID can ONLY be set once. This method
     * can ONLY be called once.
     *
     * @param id - The ID number.
     */
    public final void setId(int id) {
        this.id = id;
    }

    /**
     * Get the title of this data unit.
     *
     * @return the item title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of this data unit.
     *
     * @param title - The new data unit title.
     */
    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        fireChange(TITLE_PROPERTY, oldTitle, this.title);
        fireChange(DESCRIPTION_PROPERTY, oldTitle, this.title);
    }

    /**
     * Get the information for this data unit.
     *
     * @return the information string.
     */
    public String getInformation() {
        return information;
    }

    /**
     * The the information for this data unit.
     *
     * @param information - The new information.
     */
    public void setInformation(String information) {
        String olveValue = this.information;
        this.information = information;
        fireChange(INFORMATION_PROPERTY, olveValue, this.information);
        fireChange(DESCRIPTION_PROPERTY, olveValue, this.information);
    }

    public ObservableListWrapperA<ImageLink> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ObservableListWrapperA<ImageLink> imageLinks) {
        this.imageLinks = imageLinks;
    }

    public int getSelectedImgLinkIndex() {
        return selectedImgLinkIndex;
    }

    public void setSelectedImgLinkIndex(int selectedImgLinkIndex) {
        int oldValue = this.selectedImgLinkIndex;
        this.selectedImgLinkIndex = selectedImgLinkIndex;
        fireChange(SELECTED_ING_LINK_INDEX_PROPERTY, oldValue, this.selectedImgLinkIndex);
    }

    public String getLogoPath() {        
        return (logoPath == null || logoPath.trim().isEmpty()) ? SettingConstants.REPOSITORY_DATA_DIRECTORY + File.separator + "logo/no-image.png" : logoPath;
    }

    public void setLogoPath(String logoPath) {
        String oldValue = this.logoPath;
        this.logoPath = logoPath;
        fireChange(LOGO_PATH_PROPERTY, oldValue, this.logoPath);
    }

    public String displayMessage() {

        return title + "\n" + information;
    }
        
    public void setCommonValues(DataUnitValueWrapper commonValueWrapper) {

        title = commonValueWrapper.getTitle();
        information = commonValueWrapper.getInformation();
        imageLinks.clear();
        imageLinks.addAll(commonValueWrapper.getImageLinks());
        selectedImgLinkIndex = commonValueWrapper.getSelectedImgLinkIndex();
        logoPath = commonValueWrapper.getLogoPath();
    }

    public void addListener(String property, DataUnitChangeListener listener) {
        support.addListener(property, listener);
    }

    public boolean removeListener(String property, DataUnitChangeListener listener) {
        return support.removeListener(property, listener);
    }

    public void removeListeners() {
        support.removeListeners();
    }

    public void replaceListener(String property, DataUnitChangeListener listener) {
        support.replaceListener(property, listener);
    }
   
    public void fireChange(String property, Object oldVaue, Object newValue) {
        support.fireChange(property, oldVaue, newValue);
    }

    public void fireChange(String property) {
        support.fireChange(property);
    }

    public void fireChange() {
        support.fireChange();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataUnit other = (DataUnit) obj;

        return this.id == other.id;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
