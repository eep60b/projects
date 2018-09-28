package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantVariety extends DataUnit {

    @JsonIgnore
    public static final String ALIASES_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantVariety.ALIASES_PROPERTY";
    @JsonIgnore
    public static final String LATINNAME_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantVariety.LATINNAME_PROPERTY";

    private List<String> aliases;
    private String latinName;

    public PlantVariety() {
    }

    public PlantVariety(List<String> aliases, String latinName, String title, String information) {
        super(title, information);
        this.aliases = aliases;
        this.latinName = latinName;
    }
    
    public List<String> getAliases() {
        return new ArrayList<>(aliases);
    }

    public void setAliases(List<String> aliases) {
        this.aliases = new ArrayList<>(aliases);
        fireChange(ALIASES_PROPERTY);
    }

    public boolean addAliases(String alias) {
        boolean added = aliases.add(alias);
        fireChange(ALIASES_PROPERTY, false, added);
        return added;
    }

    public boolean removeAliases(String alias) {
        boolean removed = aliases.remove(alias);
        fireChange(ALIASES_PROPERTY, false, removed);
        return removed;
    }
    
    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        String oldValue = this.latinName;
        this.latinName = latinName;
        fireChange(LATINNAME_PROPERTY, oldValue, this.latinName);
    }

}
