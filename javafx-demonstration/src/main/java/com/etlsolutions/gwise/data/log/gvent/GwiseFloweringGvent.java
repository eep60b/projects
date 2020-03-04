package com.etlsolutions.gwise.data.log.gvent;

import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseFloweringGvent extends GwiseGvent {

    private final ValueWrapper<String> flowerTypeWrapper;
    private final ValueWrapper<Integer> countWrapper;
    private final ValueWrapper<String> colorWrapper;

    public GwiseFloweringGvent(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocalDateTime createdTime, LocalDateTime modifiedTime, LocalDateTime startTime, List<Notification> notifications, LocalDateTime endTime, String flowerType, int count, String color) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, createdTime, modifiedTime, startTime, notifications, endTime);
        flowerTypeWrapper = new ValueWrapper<>(flowerType);
        countWrapper = new ValueWrapper<>(count);
        this.colorWrapper = new ValueWrapper<>(color);
    }

    public GwiseFloweringGvent(GwiseFloweringGventBean bean) {
        super(bean);
        flowerTypeWrapper = new ValueWrapper<>(bean.getFlowerType());
        countWrapper = new ValueWrapper<>(bean.getCount());
        this.colorWrapper = new ValueWrapper<>(bean.getColor());
    }

    public String getFlowerType() {
        return flowerTypeWrapper.getValue();
    }

    public void setFlowerType(String flowerType) {
        flowerTypeWrapper.setValue(flowerType);
    }

    public ValueWrapper<String> getFlowerTypeWrapper() {
        return flowerTypeWrapper;
    }
        
    public int getCount() {
        return countWrapper.getValue();
    }

    public void setCount(int count) {
        countWrapper.setValue(count);
    }

    public ValueWrapper<Integer> getCountWrapper() {
        return countWrapper;
    }

    public String getColor() {
        return colorWrapper.getValue();
    }

    public void setColor(String color) {
        colorWrapper.setValue(color);
    }

    public ValueWrapper<String> getColorWrapper() {
        return colorWrapper;
    }

    @Override
    public GventType getType() {
        return GventType.FLOWERING;
    }

    @Override
    public GwiseFloweringGventBean getBean() {
        return new GwiseFloweringGventBean(this);
    }
    
    
}
