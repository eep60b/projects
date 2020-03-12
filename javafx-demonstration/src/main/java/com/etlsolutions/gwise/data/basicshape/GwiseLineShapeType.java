package com.etlsolutions.gwise.data.basicshape;

import com.etlsolutions.gwise.data.ShapeType;

/**
 *
 * @author ZhipengChang
 */
public enum GwiseLineShapeType implements ShapeType {
    
    ARC(""), 
    CIRCLE(""), 
    LINE(""), 
    POLYLINE("");
    
    private final String logoPath;

    private GwiseLineShapeType(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public String getLogoPath() {
        return logoPath;
    } 
}
