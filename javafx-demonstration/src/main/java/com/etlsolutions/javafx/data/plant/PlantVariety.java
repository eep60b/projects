package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitPart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantVariety extends DataUnitPart {

    @JsonIgnore
    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantVariety.TITLE_PROPERTY";
    @JsonIgnore
    public static final String ALIASES_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantVariety.ALIASES_PROPERTY";
    @JsonIgnore
    public static final String LATINNAME_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantVariety.LATINNAME_PROPERTY";

    private String title;
    private List<String> aliases;
    private String latinName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldValue = this.title;
        this.title = title;
        fireChange(TITLE_PROPERTY, oldValue, this.title);
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
