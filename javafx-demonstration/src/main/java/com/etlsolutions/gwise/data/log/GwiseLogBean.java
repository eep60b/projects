package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.time.LocalDateTime;

/**
 * Example: Events, Tasks, Issues, Tests, Notes.
 *
 * @author zc
 */
public class GwiseLogBean extends GwiseDataUnitBean {


    private LocalDateTime createdTime = LocalDateTime.now();
    private LocalDateTime modifiedTime = LocalDateTime.now();
    private LocalDateTime startTime = LocalDateTime.now();

    public GwiseLogBean() {
    }

    public GwiseLogBean(GwiseLog log) {
        super(log);
        createdTime = log.getCreatedTime();
        modifiedTime = log.getModifiedTime();
        this.startTime = log.getStartTime();
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
