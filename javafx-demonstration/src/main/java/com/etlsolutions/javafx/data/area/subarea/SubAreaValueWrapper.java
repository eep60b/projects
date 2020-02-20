package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class SubAreaValueWrapper extends DataUnitValueWrapper {

    private final ObservableListWrapperA<Location> locations;
    private final ValueWrapper<Area> areaValueWrapper;

    public SubAreaValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, ObservableListWrapperA<Location> locations, Area area) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.locations = new ObservableListWrapperA<>(locations);
        areaValueWrapper = new ValueWrapper<>(area);
    }

    public SubAreaValueWrapper(SubArea subArea) {
        super(subArea);
        locations = new ObservableListWrapperA<>(subArea.getLocations());
        areaValueWrapper = new ValueWrapper<>(ProjectManager.getInstance().<Area>getItem(subArea.getParentId()));
    }

    public ObservableListWrapperA<Location> getLocations() {
        return locations;
    }

    public ValueWrapper<Area> getAreaValueWrapper() {
        return areaValueWrapper;
    }
}
