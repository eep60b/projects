package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class PlantThinningTaskValueWrapper extends TaskValueWrapper {

    private final ValueWrapper<Integer> totalPlantsValueWrapper;
    private final ValueWrapper<Integer> thinningRatioValueWrapper;

    public PlantThinningTaskValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications, int totalPlants, int thinningRatio) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, notifications);
        this.totalPlantsValueWrapper = new ValueWrapper<>(totalPlants);
        this.thinningRatioValueWrapper = new ValueWrapper<>(thinningRatio);
    }

    public PlantThinningTaskValueWrapper(PlantThinningTask task) {
        super(task);
        this.totalPlantsValueWrapper = new ValueWrapper<>(task.getTotalPlants());
        this.thinningRatioValueWrapper = new ValueWrapper<>(task.getThinningRatio());
    }

    public ValueWrapper<Integer> getTotalPlantsValueWrapper() {
        return totalPlantsValueWrapper;
    }

    public ValueWrapper<Integer> getThinningRatioValueWrapper() {
        return thinningRatioValueWrapper;
    }

    @Override
    public TaskType getType() {
        return TaskType.PLANT_THINNING;
    }
}
