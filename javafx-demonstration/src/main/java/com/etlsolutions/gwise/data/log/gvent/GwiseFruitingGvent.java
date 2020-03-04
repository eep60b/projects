package com.etlsolutions.gwise.data.log.gvent;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.log.Notification;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseFruitingGvent extends GwiseGvent {

    private int NumberPerPlant;
    private String color;
    private String shape;
    private double averageSize;
    private double averageLength;
    private double averageWeight;

    public GwiseFruitingGvent(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocalDateTime createdTime, LocalDateTime modifiedTime, LocalDateTime startTime, List<Notification> notifications, LocalDateTime endTime,
            int NumberPerPlant, String color, String shape, double averageSize, double averageLength, double averageWeight) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, createdTime, modifiedTime, startTime, notifications, endTime);
        this.NumberPerPlant = NumberPerPlant;
        this.color = color;
        this.shape = shape;
        this.averageSize = averageSize;
        this.averageLength = averageLength;
        this.averageWeight = averageWeight;
    }

    public GwiseFruitingGvent(int NumberPerPlant, String color, String shape, double averageSize, double averageLength, double averageWeight, GwiseGventBean bean) {
        super(bean);
        this.NumberPerPlant = NumberPerPlant;
        this.color = color;
        this.shape = shape;
        this.averageSize = averageSize;
        this.averageLength = averageLength;
        this.averageWeight = averageWeight;
    }



    public int getNumberPerPlant() {
        return NumberPerPlant;
    }

    public void setNumberPerPlant(int NumberPerPlant) {
        this.NumberPerPlant = NumberPerPlant;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(double averageSize) {
        this.averageSize = averageSize;
    }

    public double getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    @Override
    public GventType getType() {
        return GventType.FRUITING;
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
