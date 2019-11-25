package com.etlsolutions.javafx.presentation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The ParameterisedImageView class is designed to represent an icon in the
 * pallette. The parameter can be a sub-area type/shape or a plant group. When
 * an object is dragged, the parameters is saved in the event object which can
 * be transferred to the target.
 *
 * @author zc
 */
public class ParameterisedImageView extends ImageView {

    private final Object[] parameters;

    public ParameterisedImageView(Object... parameters) {
        this.parameters = parameters;
    }

    public ParameterisedImageView(String url, Object... parameters) {
        super(url);
        this.parameters = parameters;
    }

    public ParameterisedImageView(Image image, Object... parameters) {
        super(image);
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return parameters;
    }
}
