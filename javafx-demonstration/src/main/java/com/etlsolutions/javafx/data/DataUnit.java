package com.etlsolutions.javafx.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The DataUnit class represents objects which are data units. The the ID for
 * this data unit. Keep the implementation as simple as possible so they can be
 * serialised easily.
 *
 * @author zc
 */
public abstract class DataUnit {

    @JsonIgnore
    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.data.DataUnit.IMG_TITLE_PROPERTY";
    @JsonIgnore
    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.data.DataUnit.IMG_INFORMATION_PROPERTY";
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

    protected DataUnit(int id, String title, String information) {
        this.id = id;
        this.title = title;
        this.information = information;
    }

    protected DataUnit(String title, String information) {
        this(DataUnitIdRegistry.getInstance().createNewId(), title, information);
        this.imageLinks = new ObservableListWrapperA<>();
    }

    protected DataUnit(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        this(title, information);
        this.imageLinks = new ObservableListWrapperA<>(imageLinks);
    }

    protected DataUnit(int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        this(id, title, information);
        this.imageLinks = new ObservableListWrapperA<>(imageLinks);
        this.selectedImgLinkIndex = selectedImgLinkIndex;
        this.logoPath = logoPath;
    }

    public DataUnit(DataUnitValueWrapper valueWrapper) {
        this(valueWrapper.getTitle(), valueWrapper.getInformation(), valueWrapper.getImageLinks(), 
                valueWrapper.getSelectedImgLinkIndex(), valueWrapper.getLogoPath());
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
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        String oldValue = this.logoPath;
        this.logoPath = logoPath;
        fireChange(LOGO_PATH_PROPERTY, oldValue, this.logoPath);
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
