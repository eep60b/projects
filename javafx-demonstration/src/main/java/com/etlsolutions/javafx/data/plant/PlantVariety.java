package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
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
    private int plantSubGroupId;

    public PlantVariety() {
    }

    public PlantVariety(PlantVarietyValueWrapper valueWrapper) {
        super(valueWrapper);
        aliases = new ObservableListWrapperA<>(valueWrapper.getAliases());
        latinName = valueWrapper.getLatinNameValueWrapper().getValue();
        PlantSubGroup subGroup = valueWrapper.getPlantSubGroupValueWrapper().getValue();
        plantSubGroupId = subGroup == null ? 0 : subGroup.getId();
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

    public int getPlantSubGroupId() {
        return plantSubGroupId;
    }

    public void setPlantSubGroupId(int plantSubGroupId) {
        this.plantSubGroupId = plantSubGroupId;
    }
    
    public void setValues(PlantVarietyValueWrapper valueWrapper) {
        setCommonValues(valueWrapper);
        aliases = new ObservableListWrapperA<>(valueWrapper.getAliases());
        latinName = valueWrapper.getLatinNameValueWrapper().getValue();
        plantSubGroupId = valueWrapper.getPlantSubGroupValueWrapper().getValue().getId();
    }
}
