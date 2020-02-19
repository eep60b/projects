package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantSubgroupLocationSetBean extends GwiseDataUnitBean {

    private int parentId;
    private int plantSetId;
    private List<GwiseLocationSetBean> locationSets;
    
    public GwisePlantSubgroupLocationSetBean() {
    }

    public GwisePlantSubgroupLocationSetBean(GwisePlantSubgroupLocationSet set) {
        super(set);
        parentId = set.getParent().getId();
        plantSetId = set.getId();
        locationSets = new ArrayList<>();
        for(GwiseLocationSet bean : set.getLocationSets()) {
            locationSets.add(new GwiseLocationSetBean(bean));
        }
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPlantSetId() {
        return plantSetId;
    }

    public void setPlantSetId(int plantSetId) {
        this.plantSetId = plantSetId;
    }
    
    public List<GwiseLocationSetBean> getLocationSets() {
        return locationSets;
    }

    public void setLocationSets(List<GwiseLocationSetBean> locationSets) {
        this.locationSets = locationSets;
    }
}
