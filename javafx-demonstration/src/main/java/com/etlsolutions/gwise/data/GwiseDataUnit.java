package com.etlsolutions.gwise.data;

import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.util.ArrayList;
import java.util.List;

/**
 * The DataUnit class represents objects which are data units. Keep the
 * implementation as simple as possible so they can be serialised easily.
 *
 * @author zc
 */
public abstract class GwiseDataUnit {

    private int id = 0;
    private String title = "";
    private String information = "";
    private List<ImageLink> imageLinks = new ArrayList<>();
    private int selectedImgLinkIndex = 0;
    private String logoPath = "";

    /**
     * The default constructor. Reserved for being a proper java bean.
     */
    public GwiseDataUnit() {
    }

    protected GwiseDataUnit(String title) {
        this.id = DataUnitIdRegistry.getInstance().createNewId();
        this.title = title;
        this.information = "";
        this.imageLinks = new ObservableListWrapperA<>();
    }

    public GwiseDataUnit(GwiseDataUnitWrapper valueWrapper) {
        setDataUnitValues(valueWrapper);
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
        this.title = title;
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
        this.information = information;
    }

    public List<ImageLink> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<ImageLink> imageLinks) {
        this.imageLinks = new ArrayList<>(imageLinks);
    }

    public int getSelectedImgLinkIndex() {
        return selectedImgLinkIndex;
    }

    public void setSelectedImgLinkIndex(int selectedImgLinkIndex) {
        this.selectedImgLinkIndex = selectedImgLinkIndex;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public void setValues(GwiseDataUnitWrapper commonValueWrapper) {

        setDataUnitValues(commonValueWrapper);
    }    
    
    private void setDataUnitValues(GwiseDataUnitWrapper commonValueWrapper) {
        setTitle(commonValueWrapper.getTitle());
        setInformation(commonValueWrapper.getInformation());
        setImageLinks(commonValueWrapper.getImageLinks());
        setSelectedImgLinkIndex(commonValueWrapper.getSelectedImgLinkIndex());
        setLogoPath(commonValueWrapper.getLogoPath());
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
        final GwiseDataUnit other = (GwiseDataUnit) obj;

        return this.id == other.id;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}