package com.etlsolutions.gwise.data;

import com.etlsolutions.javafx.data.*;
import java.util.List;

/**
 * The GwiseDataUnit class represents areas, subareas, plant etc which will be
 * serialised to disk. Keep the implementation as simple as possible so they can
 * be serialised easily.
 *
 * @author zc
 */
public abstract class GwiseDataUnit extends DoubleValueWrapper implements LogoItem {

    private final int id;
    private final ValueWrapper<String> titleWrapper;
    private final ValueWrapper<String> informationWrapper;
    private final ObservableListWrapperA<ImageLink> imageLinks;
    private final ValueWrapper<Integer> selectedImageLinkIndexWrapper;
    private final ValueWrapper<String> logoPathWrapper;

    public GwiseDataUnit(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {

        this.id = id;
        titleWrapper = new ValueWrapper<>(title);
        informationWrapper = new ValueWrapper<>(information);
        this.imageLinks = new ObservableListWrapperA<>(imageLinks);
        selectedImageLinkIndexWrapper = new ValueWrapper<>(selectedImgLinkIndex);
        logoPathWrapper = new ValueWrapper<>(logoPath);
    }

    public GwiseDataUnit(GwiseDataUnitBean bean) {
        this(bean.getId(), bean.getTitle(), bean.getInformation(), bean.getImageLinks(), bean.getSelectedImgLinkIndex(), bean.getLogoPath());
    }

    /**
     * Get the bean from this item.
     *
     * @return the bean.
     */
    public abstract GwiseDataUnitBean getBean();

    public int getId() {
        return id;
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

    public ValueWrapper<Integer> getSelectedImageLinkIndexWrapper() {
        return selectedImageLinkIndexWrapper;
    }

    public ImageLink getSelectedImageLink() {
        return imageLinks.isEmpty() ? null : imageLinks.get(selectedImageLinkIndexWrapper.getValue());
    }

    public ValueWrapper<String> getLogoPathWrapper() {
        return logoPathWrapper;
    }

    @Override
    public String getLogoPath() {
        return logoPathWrapper.getValue();
    }

    public int getSelectedImgLinkIndex() {
        return imageLinks.isEmpty() ? 0 : imageLinks.indexOf(getSelectedImageLink());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        return titleWrapper.getValue();
    }
}
