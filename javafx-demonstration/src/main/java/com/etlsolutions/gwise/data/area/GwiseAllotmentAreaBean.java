package com.etlsolutions.gwise.data.area;

/**
 *
 * @author ZhipengChang
 */
public class GwiseAllotmentAreaBean extends GwiseAreaBean {

    public GwiseAllotmentAreaBean() {
    }

    public GwiseAllotmentAreaBean(GwiseAllotmentArea area) {
        super(area);
    }
 
 //   @Override
    public AreaType type() {
        return AreaType.ALLOTMENT;
    }
    
}
