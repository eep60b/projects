package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.LogoItem;
import com.etlsolutions.gwise.data.ShapeType;

/**
 *
 * @author ZhipengChang
 */
public class SubareaLogoItem implements LogoItem {

    private final GwiseSubAreaType subAreaType;
    private final ShapeType shapeType;
    private final String logoPath;

    public SubareaLogoItem(GwiseSubAreaType subAreaType, ShapeType shapeType, String logoPath) {
        this.subAreaType = subAreaType;
        this.shapeType = shapeType;
        this.logoPath = logoPath;
    }

    public GwiseSubAreaType getSubAreaType() {
        return subAreaType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public String getLogoPath() {
        return logoPath;
    }
}
