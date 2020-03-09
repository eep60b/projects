package com.etlsolutions.gwise.data.area;

/**
 *
 * @author ZhipengChang
 */
public class GwiseFarmAreaBean extends GwiseAreaBean {

    public GwiseFarmAreaBean() {
    }

    public GwiseFarmAreaBean(GwiseFarmArea area) {
        super(area);
    }

 //   @Override
    public AreaType type() {
        return AreaType.FARM;
    }
}
