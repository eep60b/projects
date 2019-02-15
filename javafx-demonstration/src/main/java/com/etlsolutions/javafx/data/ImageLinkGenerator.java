package com.etlsolutions.javafx.data;

/**
 *
 * @author zc
 */
public class ImageLinkGenerator {

    private static final ImageLinkGenerator INSTANCE = new ImageLinkGenerator();
        
    private ImageLinkGenerator() {
    }
    
    public static final ImageLinkGenerator getInstance() {
        return INSTANCE;
    }
    
    public ImageLink generateImageLink(String link, String information) {
        
        //TODO: add path;
        
        return new ImageLink(link, information);
    }
    
}
