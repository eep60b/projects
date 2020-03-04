package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantGroupBean extends GwiseDataUnitBean {

    private List<PlantTypeBean> plantTypeBeans;
    private List<GwisePlantSubgroupBean> plantSubgroupBeans;
    
    public GwisePlantGroupBean() {
    }

    public GwisePlantGroupBean(GwisePlantGroup group) {
        super(group);
        plantSubgroupBeans = new ArrayList<>();
        for(GwisePlantSubgroup subgroup : group.getPlantSubgroups()) {
            plantSubgroupBeans.add(new GwisePlantSubgroupBean(subgroup));
        }
    }

    public List<PlantTypeBean> getPlantTypeBeans() {
        return plantTypeBeans;
    }

    public void setPlantTypeBeans(List<PlantTypeBean> plantTypeBeans) {
        this.plantTypeBeans = plantTypeBeans;
    }

    public List<GwisePlantSubgroupBean> getPlantSubgroupBeans() {
        return plantSubgroupBeans;
    }

    public void setPlantSubgroupBeans(List<GwisePlantSubgroupBean> plantSubgroupBeans) {
        this.plantSubgroupBeans = plantSubgroupBeans;
    }

}
