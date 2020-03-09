package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**

 * 
 * @author ZhipengChang
 */
public class GwiseAreaRootBean extends GwiseDataUnitBean {

    private List<GwiseAreaBean> areas = new ArrayList<>();   

    public GwiseAreaRootBean() {
    }
        
    public GwiseAreaRootBean(GwiseAreaRoot r) {
        super(r);        
        for(GwiseArea a : r.getAreas()) {
            areas.add(a.getBean());
        }
    }

    public List<GwiseAreaBean> getAreas() {
        return areas;
    }

    public void setAreas(List<GwiseAreaBean> areas) {
        this.areas = areas;
    }
}