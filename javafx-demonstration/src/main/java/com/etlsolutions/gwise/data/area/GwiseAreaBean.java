package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;

/**
 *
 * @author ZhipengChang
 */
public abstract class GwiseAreaBean extends GwiseDataUnitBean {

    public GwiseAreaBean() {
    }

    public GwiseAreaBean(GwiseArea area) {
        super(area);
    }

    public abstract AreaType type();
}
