package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.LogoItem;
import com.etlsolutions.gwise.data.basicshape.GwiseShapeType;

/**
 *
 * @author ZhipengChang
 */
public class SubareaLogoItem implements LogoItem {

    private final GwiseSubAreaType subAreaType;
    private final GwiseShapeType shapeType;
    private final String logoPath;

    public SubareaLogoItem(GwiseSubAreaType subAreaType, GwiseShapeType shapeType, String logoPath) {
        this.subAreaType = subAreaType;
        this.shapeType = shapeType;
        this.logoPath = logoPath;
    }

    public GwiseSubAreaType getSubAreaType() {
        return subAreaType;
    }

    public GwiseShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public String getLogoPath() {
        return logoPath;
    }
}
