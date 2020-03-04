package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.subarea.GwisePlantBed;
import com.etlsolutions.gwise.data.subarea.GwisePlantBedBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGardenAreaBean extends GwiseAreaBean {
    
    private List<GwisePlantBedBean> plantBeds = new ArrayList<>(); 

    public GwiseGardenAreaBean() {
    }

    public GwiseGardenAreaBean(GwiseGardenArea area) {
        super(area);
        for(GwisePlantBed bean : area.getPlantBeds()) {
            plantBeds.add(new GwisePlantBedBean(bean));
        }
    }

    @Override
    public AreaType type() {
        return AreaType.GARDEN;
    }

    public List<GwisePlantBedBean> getPlantBeds() {
        return plantBeds;
    }

    public void setPlantBeds(List<GwisePlantBedBean> plantBeds) {
        this.plantBeds = plantBeds;
    }    
}
