package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantVarietyBean extends GwiseDataUnitBean {

    private List<String> aliases;
    private String latinName;    
    private int plantSubGroupId;    
    
    public GwisePlantVarietyBean() {
    }

    public GwisePlantVarietyBean(GwisePlantVariety variety) {
        super(variety);
        
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public int getPlantSubGroupId() {
        return plantSubGroupId;
    }

    public void setPlantSubGroupId(int plantSubGroupId) {
        this.plantSubGroupId = plantSubGroupId;
    }
}
