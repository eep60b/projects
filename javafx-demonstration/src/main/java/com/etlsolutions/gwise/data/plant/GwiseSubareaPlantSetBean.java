package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseSubareaPlantSetBean extends GwiseDataUnitBean {

    private List<GwiseLocationPlantSetBean> locationPlantSets;
    private int plantSubgroupId;    
    private int subareaId;
    
    public GwiseSubareaPlantSetBean() {
    }

    public GwiseSubareaPlantSetBean(GwiseSubareaPlantSet set) {
        super(set);
        locationPlantSets = new ArrayList<>();
        for(GwiseLocationPlantSet plant : set.getLocationPlantSets()) {
            locationPlantSets.add(new GwiseLocationPlantSetBean(plant));
        }
        plantSubgroupId = set.getPlantSubgroupId();
        subareaId = set.getSubareaId();
    }   

    public List<GwiseLocationPlantSetBean> getLocationPlantSets() {
        return locationPlantSets;
    }

    public void setLocationPlantSets(List<GwiseLocationPlantSetBean> locationPlantSets) {
        this.locationPlantSets = locationPlantSets;
    }

    public int getPlantSubgroupId() {
        return plantSubgroupId;
    }

    public void setPlantSubgroupId(int plantSubgroupId) {
        this.plantSubgroupId = plantSubgroupId;
    }

    public int getSubareaId() {
        return subareaId;
    }

    public void setSubareaId(int subareaId) {
        this.subareaId = subareaId;
    }    
}
