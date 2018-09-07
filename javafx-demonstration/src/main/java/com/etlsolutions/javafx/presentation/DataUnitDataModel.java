package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class DataUnitDataModel implements TitleDataModel, InformationDataModel, ImageLinkDataModel {

    private final List<ImageLink> imageLinks = new ArrayList<>();
    
    @Override
    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(ImageLink link) {
        imageLinks.add(link);
    }

    @Override
    public void remove(ImageLink link) {
        imageLinks.remove(link);
    }

    @Override
    public void setInformation(String information) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ImageLink> getImageLinks() {
        return new ArrayList<>(imageLinks);
    }
    
}
