package com.etlsolutions.gwise.data.basicshape;

import com.etlsolutions.gwise.data.ShapeType;

/**
 *
 * @author ZhipengChang
 */
public enum GwiseShapeType implements ShapeType {

    CIRCLE(""),
    POLYGON(""),
    RECTANGLE(""),
    SQUARE(""),
    TRIANGLE("");

    private final String logoPath;

    private GwiseShapeType(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public String getLogoPath() {
        return logoPath;
    }
}
