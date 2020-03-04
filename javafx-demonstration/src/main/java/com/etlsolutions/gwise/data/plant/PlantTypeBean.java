package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class PlantTypeBean extends GwiseDataUnitBean {

    private List<GwisePlantVarietyBean> plantVarieties;
    
    public PlantTypeBean() {
    }

    public PlantTypeBean(PlantType type) {
        super(type);
    }  

    public List<GwisePlantVarietyBean> getPlantVarieties() {
        return plantVarieties;
    }

    public void setPlantVarieties(List<GwisePlantVarietyBean> plantVarieties) {
        this.plantVarieties = plantVarieties;
    }
}
