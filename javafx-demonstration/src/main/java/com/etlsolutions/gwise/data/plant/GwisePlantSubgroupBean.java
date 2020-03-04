package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantSubgroupBean extends GwiseDataUnitBean {

    /**
     * The parent plant group id of this plant subgroup. This field can be used
     * to look up its parent when necessary.
     */
    private int parentId;
    
    /**
     * The plant type id fo this plant subgroup. 
     */
    private int plantTypeId;

    /**
     * All the plantSets belong to this plant sub group.
     */
    private List<GwiseLocationPlantSet> plantSets;

    /**
     * All the plant varieties belong to this plant sub group.
     *
     * This property will not be shown in the tree.
     *
     */
    private List<GwisePlantVariety> plantVarieties;

    public GwisePlantSubgroupBean() {
    }

    public GwisePlantSubgroupBean(GwisePlantSubgroup subgroup) {
        super(subgroup);
        parentId = subgroup.getParentId();
        plantTypeId = subgroup.getPlantType().getId();
    }

    public int getParentId() {
        return parentId;
    }

    public int getPlantTypeId() {
        return plantTypeId;
    }

    public void setPlantTypeId(int plantTypeId) {
        this.plantTypeId = plantTypeId;
    }
   
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<GwiseLocationPlantSet> getPlantSets() {
        return plantSets;
    }

    public void setPlantSets(List<GwiseLocationPlantSet> plantSets) {
        this.plantSets = plantSets;
    }

    public List<GwisePlantVariety> getPlantVarieties() {
        return plantVarieties;
    }

    public void setPlantVarieties(List<GwisePlantVariety> plantVarieties) {
        this.plantVarieties = plantVarieties;
    }
}
