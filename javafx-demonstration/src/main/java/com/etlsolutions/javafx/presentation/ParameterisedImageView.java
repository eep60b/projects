package com.etlsolutions.javafx.presentation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
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