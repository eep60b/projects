package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.data.plant.PlantType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ZhipengChang
 */
public class PlantTypeImageView extends ImageView {
    
    private final PlantType type;

    public PlantTypeImageView(PlantType type) {
        this.type = type;
    }

    public PlantTypeImageView(PlantType type, String url) {
        super(url);
        this.type = type;
    }

    public PlantTypeImageView(PlantType type, Image image) {
        super(image);
        this.type = type;
    }
        

    public PlantType getType() {
        return type;
    }
}
