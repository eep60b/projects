package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Example: Events, Tasks, Issues, Tests, Note.
 *
 * @author zc
 */
public abstract class GwiseLog extends GwiseDataUnit {

    private final ValueWrapper<LocalDateTime> createdTimeWrapper;

    private final ValueWrapper<LocalDateTime> modifiedTimeWrapper;

    private final ValueWrapper<LocalDateTime> startTimeWrapper;

    public GwiseLog(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocalDateTime createdTime, LocalDateTime modifiedTime, LocalDateTime startTime) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        createdTimeWrapper = new ValueWrapper<>(createdTime);
        modifiedTimeWrapper = new ValueWrapper<>(modifiedTime);
        startTimeWrapper = new ValueWrapper<>(startTime);
    }

    public GwiseLog(GwiseLogBean bean) {
        super(bean);
        createdTimeWrapper = new ValueWrapper<>(bean.getCreatedTime());
        modifiedTimeWrapper = new ValueWrapper<>(bean.getModifiedTime());
        startTimeWrapper = new ValueWrapper<>(bean.getStartTime());
    }

    public LocalDateTime getCreatedTime() {
        return createdTimeWrapper.getValue();
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        createdTimeWrapper.setValue(createdTime);
    }

    public ValueWrapper<LocalDateTime> getCreatedTimeWrapper() {
        return createdTimeWrapper;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTimeWrapper.getValue();
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        modifiedTimeWrapper.setValue(modifiedTime);
    }

    public ValueWrapper<LocalDateTime> getModifiedTimeWrapper() {
        return modifiedTimeWrapper;
    }

    public LocalDateTime getStartTime() {
        return startTimeWrapper.getValue();
    }

    public void setStartTimeWrapper(LocalDateTime startTime) {
        startTimeWrapper.setValue(startTime);
    }

    public ValueWrapper<LocalDateTime> getStartTimeWrapper() {
        return startTimeWrapper;
    }

    public int getYear() {
        return startTimeWrapper.getValue().getYear();
    }
    
    public int getMonth() {
        return startTimeWrapper.getValue().getMonth().getValue();
    }
}
