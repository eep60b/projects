package com.etlsolutions.gwise.data.area;

/**
 *
 * @author ZhipengChang
 */
public class GwiseIndoorAreaBean extends GwiseAreaBean {

    public GwiseIndoorAreaBean() {
    }

    public GwiseIndoorAreaBean(GwiseIndoorArea area) {
        super(area);
    }



    @Override
    public AreaType type() {
        return AreaType.INDOOR;
    }
    
}
