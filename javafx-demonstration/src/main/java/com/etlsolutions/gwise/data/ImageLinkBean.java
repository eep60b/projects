package com.etlsolutions.gwise.data;

/**
 * The ImageLink class represents the path to a image on and its information.
 *
 * @author zc
 */
public class ImageLinkBean {

    private int id;

    /**
     * The link is the string path which points to the original location of the
     * image. After loading, the original image should be copied and modified to
     * suit the purpose of this application. The copied image will be saved to
     * the path location. The link then will only provide a reference. It later
     * can be used to compare the origin of two images.
     */
    private String link;

    /**
     * Any additional information is saved here as a text.
     */
    private String information;

    /**
     * The path is the location of current image.
     */
    private String path;

    public ImageLinkBean() {
    }

    public ImageLinkBean(ImageLink link) {
        this.id = link.getId();
        this.link = link.getLink();
        this.information = link.getInformation();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
