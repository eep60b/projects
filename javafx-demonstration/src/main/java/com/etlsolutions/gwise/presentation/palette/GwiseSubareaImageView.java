package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.data.basicshape.GwiseShapeType;
import com.etlsolutions.gwise.data.subarea.GwiseSubAreaType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ZhipengChang
 */
public class GwiseSubareaImageView extends ImageView {
    
    private final GwiseSubAreaType subareaType;
    private final GwiseShapeType shapeType;

    public GwiseSubareaImageView(GwiseSubAreaType subAreaType, GwiseShapeType shapeType) {
        this.subareaType = subAreaType;
        this.shapeType = shapeType;
    }

    public GwiseSubareaImageView(GwiseSubAreaType gwiseSubAreaType, GwiseShapeType gwiseShapeType, String url) {
        super(url);
        this.subareaType = gwiseSubAreaType;
        this.shapeType = gwiseShapeType;
    }

    public GwiseSubareaImageView(GwiseSubAreaType gwiseSubAreaType, GwiseShapeType gwiseShapeType, Image image) {
        super(image);
        this.subareaType = gwiseSubAreaType;
        this.shapeType = gwiseShapeType;
    }

    public GwiseSubAreaType getSubareaType() {
        return subareaType;
    }

    public GwiseShapeType getShapeType() {
        return shapeType;
    }    
}
