package com.etlsolutions.gwise.data;

/**
 * The ImageLink class represents the path to a image on and its information.
 *
 * @author zc
 */
public class ImageLink {

    private final int id;

    /**
     * The link is the string path which points to the original location of the
     * image. After loading, the original image should be copied and modified to
     * suit the purpose of this application. The copied image will be saved to
     * the path location. The link then will only provide a reference. It later
     * can be used to compare the origin of two images.
     */
    private final ValueWrapper<String> linkWrapper;

    /**
     * Any additional information is saved here as a text.
     */
    private final ValueWrapper<String> informationWrapper;

    /**
     * The path is the location of current image.
     */
    private String path;

    public ImageLink(int id, String link, String information) {
        this.id = id;
        linkWrapper = new ValueWrapper<>(link);
        informationWrapper = new ValueWrapper<>(information);
    }

    public ImageLink(ImageLinkBean bean) {
        id = bean.getId();
        linkWrapper = new ValueWrapper<>(bean.getLink());
        informationWrapper = new ValueWrapper<>(bean.getInformation());
    }

    public int getId() {
        return id;
    }

    /**
     * Get the original link of this image. It can be a URL or a path in local
     * physical disk. The link is not always valid.
     *
     * @return the original link.
     */
    public String getLink() {
        return linkWrapper.getValue();
    }

    public void setLink(String link) {
        linkWrapper.setValue(link);
    }

    public ValueWrapper<String> getLinkWrapper() {
        return linkWrapper;
    }

    public String getInformation() {
        return informationWrapper.getValue();
    }

    public void setInformation(String information) {
        informationWrapper.setValue(information);
    }

    public ValueWrapper<String> getInformationWrapper() {
        return informationWrapper;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImageLinkBean getBean() {
        return new ImageLinkBean(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
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
        final ImageLink other = (ImageLink) obj;
        return this.id == other.id;
    }
}
