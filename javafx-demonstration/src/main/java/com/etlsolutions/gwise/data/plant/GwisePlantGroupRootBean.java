package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantGroupRootBean extends GwiseDataUnitBean {

    private List<GwisePlantGroupBean> plantGroups;

    public GwisePlantGroupRootBean() {
    }

    public GwisePlantGroupRootBean(GwisePlantGroupRoot root) {
        super(root);
    }

    public List<GwisePlantGroupBean> getPlantGroups() {
        return plantGroups;
    }

    public void setPlantGroups(List<GwisePlantGroupBean> plantGroups) {
        this.plantGroups = plantGroups;
    }
}
