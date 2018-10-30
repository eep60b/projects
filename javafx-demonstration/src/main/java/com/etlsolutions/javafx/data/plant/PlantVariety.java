package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class PlantVariety extends DataUnit {

    @JsonIgnore
    public static final String LATINNAME_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantVariety.LATINNAME_PROPERTY";

    private ObservableListWrapperA<String> aliases;
    private String latinName;
    
    private int plantTypeId;

    public PlantVariety() {
    }

    public PlantVariety(ObservableListWrapperA<String> aliases, String latinName, int PlantTypeId, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.aliases = aliases;
        this.latinName = latinName;
        this.plantTypeId = PlantTypeId;
    }

    public PlantVariety(ObservableListWrapperA<String> aliases, String latinName, int PlantTypeId, int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.aliases = aliases;
        this.latinName = latinName;
        this.plantTypeId = PlantTypeId;
    }

    public ObservableListWrapperA<String> getAliases() {
        return aliases;
    }
    
    public void setAliases(ObservableListWrapperA<String> aliases) {
        this.aliases = aliases;
    }
    
    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        String oldValue = this.latinName;
        this.latinName = latinName;
        fireChange(LATINNAME_PROPERTY, oldValue, this.latinName);
    }

    public int getPlantTypeId() {
        return plantTypeId;
    }

    public void setPlantTypeId(int plantTypeId) {
        this.plantTypeId = plantTypeId;
    }
}
