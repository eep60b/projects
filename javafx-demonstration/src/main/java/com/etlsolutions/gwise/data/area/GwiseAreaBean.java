package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.gwise.data.subarea.GwiseSubareaBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseAreaBean extends GwiseDataUnitBean {

    private AreaType type = AreaType.GARDEN;
    private List<GwiseSubareaBean> subareas = new ArrayList<>();

    public GwiseAreaBean() {
    }

    public GwiseAreaBean(GwiseArea area) {

        super(area);
        for (GwiseSubarea subarea : area.getSubareas()) {
            subareas.add(new GwiseSubareaBean(subarea));
        }
    }

    public AreaType getType() {
        return type;
    }

    public void setType(AreaType type) {
        this.type = type;
    }

    public List<GwiseSubareaBean> getSubareas() {
        return subareas;
    }

    public void setSubareas(List<GwiseSubareaBean> subareas) {
        this.subareas = subareas;
    }
}
