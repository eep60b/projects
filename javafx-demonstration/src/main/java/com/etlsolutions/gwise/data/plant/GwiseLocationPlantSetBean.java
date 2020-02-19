package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLocationPlantSetBean extends GwiseDataUnitBean {

    private List<GwisePlantBean> plants;
    private int subareaPlantSetId;    
    private int locationSetId;
    
    public GwiseLocationPlantSetBean() {
    }

    public GwiseLocationPlantSetBean(GwiseLocationPlantSet set) {
        super(set);
        plants = new ArrayList<>();
        for(GwisePlant plant : set.getPlants()) {
            plants.add(new GwisePlantBean(plant));
        }
        subareaPlantSetId = set.getSubareaPlantSetId();
        locationSetId = set.getLocationSetId();
    }   

    public List<GwisePlantBean> getPlants() {
        return plants;
    }

    public void setPlants(List<GwisePlantBean> plants) {
        this.plants = plants;
    }

    public int getSubareaPlantSetId() {
        return subareaPlantSetId;
    }

    public void setSubareaPlantSetId(int subareaPlantSetId) {
        this.subareaPlantSetId = subareaPlantSetId;
    }

    public int getLocationSetId() {
        return locationSetId;
    }

    public void setLocationSetId(int locationSetId) {
        this.locationSetId = locationSetId;
    }    
}
