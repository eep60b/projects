package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.locations.GwiseLocation;
import com.etlsolutions.gwise.data.other.GwiseGrowingMedium;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.plant.GrowingStartPoint;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlant extends GwiseDataUnit {

    private final GwiseLocationPlantSet plants;
    private final ValueWrapper<GwiseLocation> locationValueWrapper;
    private final ValueWrapper<Boolean> isAliveValueWrapper;
    private final ValueWrapper<GrowingStartPoint> growingStartPointValueWrapper;
    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<GwiseGrowingMedium> growingMediumValueWrapper;
    private final GwisePlantVariety plantVariety;
    private final ValueWrapper<String> terminationReasonValueWrapper; //Harvested. destroied by disease, insecte, cold weather, hot weather, droupht, tater log, high wind, over-fertiliser.
    private final ValueWrapper<LocalDateTime> terminationTimeValueWrapper;
    private ObservableListWrapperA<Gvent> gvents;
    private ObservableListWrapperA<GrowingIssue> growingIssues;
    private ObservableListWrapperA<GrowingObservation> growingObservations;
    private ObservableListWrapperA<Task> tasks;

    public GwisePlant(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            int plantsId, int locationId, boolean isAlive, GrowingStartPoint startPoint, LocalDateTime startDateTime, int growingMediumnId,
            int plantVarietyId, String terminationReason, LocalDateTime terminationTime) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);

        this.plants = null; // Todo: plants;
        locationValueWrapper = null; //new ValueWrapper<>(location);
        isAliveValueWrapper = new ValueWrapper<>(isAlive);
        growingStartPointValueWrapper = new ValueWrapper<>(startPoint);
        startTimeValueWrapper = new ValueWrapper<>(startDateTime);
        growingMediumValueWrapper = null;
        this.plantVariety = null; //plantVariety;
        terminationReasonValueWrapper = new ValueWrapper<>(terminationReason);
        terminationTimeValueWrapper = new ValueWrapper<>(terminationTime);
    }

    public GwisePlant(GwisePlantBean bean) {
        this(bean.getId(), bean.getTitle(), bean.getInformation(), bean.getImageLinks(), bean.getSelectedImgLinkIndex(), bean.getLogoPath(),
                bean.getPlantsId(), bean.getLocationId(), bean.isIsAlive(), bean.getGrowingStartPoint(), bean.getStartTime(), bean.getPlantVarietyId(), bean.getGrowingMediumId(),
                bean.getTerminationReason(), bean.getTerminationTime());
    }

    @Override
    public GwisePlantBean getBean() {
        return new GwisePlantBean(this);
    }

    /**
     * Get the Plants object which is the set of plants which contains this
     * plant. It the parent of this object.
     *
     * @return the Plants object.
     */
    public GwiseLocationPlantSet getPlants() {
        return plants;
    }

    public ValueWrapper<GwiseLocation> getLocationValueWrapper() {
        return locationValueWrapper;
    }

    public ValueWrapper<Boolean> getIsAliveValueWrapper() {
        return isAliveValueWrapper;
    }

    public ValueWrapper<GrowingStartPoint> getGrowingStartPointValueWrapper() {
        return growingStartPointValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }

    public ValueWrapper<GwiseGrowingMedium> getGrowingMediumValueWrapper() {
        return growingMediumValueWrapper;
    }

    public GwisePlantVariety getPlantVariety() {
        return plantVariety;
    }

    public ValueWrapper<String> getTerminationReasonValueWrapper() {
        return terminationReasonValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getTerminationTimeValueWrapper() {
        return terminationTimeValueWrapper;
    }

    public ObservableListWrapperA<Gvent> getGvents() {
        return gvents;
    }

    public ObservableListWrapperA<GrowingIssue> getGrowingIssues() {
        return growingIssues;
    }

    public ObservableListWrapperA<GrowingObservation> getGrowingObservations() {
        return growingObservations;
    }

    public ObservableListWrapperA<Task> getTasks() {
        return tasks;
    }

}
