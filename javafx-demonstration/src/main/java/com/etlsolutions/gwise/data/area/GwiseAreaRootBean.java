package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.List;

/**

 * 
 * @author ZhipengChang
 */
public class GwiseAreaRootBean extends GwiseDataUnitBean {

    private List<GwiseAreaBean> areas;    
    
    public GwiseAreaRootBean(GwiseAreaRoot r) {
        super(r);
    }

    
    


    public List<GwiseAreaBean> getAreas() {
        return areas;
    }

    public void setAreas(List<GwiseAreaBean> areas) {
        this.areas = areas;
    }
}