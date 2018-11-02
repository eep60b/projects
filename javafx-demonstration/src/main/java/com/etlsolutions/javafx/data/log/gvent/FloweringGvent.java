package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class FloweringGvent extends Gvent {

    private String flowerType;
    private int count;
    private String color;

    public FloweringGvent() {
    }

    public FloweringGvent(String flowerType, int numberPerPlant, String color, LocalDateTime endTime, LocalDateTime modifiedTime, LocalDateTime startTime, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(endTime, modifiedTime, startTime, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.flowerType = flowerType;
        this.count = numberPerPlant;
        this.color = color;
    }

    public FloweringGvent(String flowerType, int count, String color, LocalDateTime endTime, LocalDateTime modifiedTime, LocalDateTime startTime, int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(endTime, modifiedTime, startTime, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.flowerType = flowerType;
        this.count = count;
        this.color = color;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public GventType getType() {
        return GventType.FLOWERING;
    }
}
