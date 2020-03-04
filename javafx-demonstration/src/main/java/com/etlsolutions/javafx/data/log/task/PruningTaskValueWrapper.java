package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class PruningTaskValueWrapper extends TaskValueWrapper {

    private final ValueWrapper<String> overallRemovedValueWrapper;
    private final ValueWrapper<String> eachBranchRemovedValueWrapper;

    public PruningTaskValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications, double overallRemoved, double eachBranchRemoved) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, notifications);
        overallRemovedValueWrapper = getWrapper(overallRemoved);
        eachBranchRemovedValueWrapper = getWrapper(eachBranchRemoved);
    }

    public PruningTaskValueWrapper(PruningTask task) {
        super(task);
        this.overallRemovedValueWrapper = getWrapper(task.getOverallRemoved());
        this.eachBranchRemovedValueWrapper = getWrapper(task.getEachBranchRemoved());
    }

    public ValueWrapper<String> getOverallRemovedValueWrapper() {
        return overallRemovedValueWrapper;
    }

    public double getOverallRemoved() {
        return Double.parseDouble(overallRemovedValueWrapper.getValue());
    }
    
    public ValueWrapper<String> getEachBranchRemovedValueWrapper() {
        return eachBranchRemovedValueWrapper;
    }
       
    public double getEachBranchRemoved() {
        return Double.parseDouble(eachBranchRemovedValueWrapper.getValue());
    }
    
    @Override
    public TaskType getType() {
        return TaskType.PRUNING;
    }

}
