package com.etlsolutions.gwise.data.area;

/**
 *
 * @author ZhipengChang
 */
public class GwisePatioAreaBean extends GwiseAreaBean {

    public GwisePatioAreaBean() {
    }

    public GwisePatioAreaBean(GwisePatioArea area) {
        super(area);
    }

    @Override
    public AreaType type() {
        return AreaType.PATIO;
    }

    
}
