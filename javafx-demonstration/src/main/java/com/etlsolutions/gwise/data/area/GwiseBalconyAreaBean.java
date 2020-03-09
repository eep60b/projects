package com.etlsolutions.gwise.data.area;

/**
 *
 * @author ZhipengChang
 */
public class GwiseBalconyAreaBean extends GwiseAreaBean {

    public GwiseBalconyAreaBean() {
    }

    public GwiseBalconyAreaBean(GwiseBalconyArea area) {
        super(area);
    }    

 //   @Override
    public AreaType type() {
        return AreaType.BALCONY;
    }
}
