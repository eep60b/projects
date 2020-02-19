package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.util.List;

/**
 * The GwiseSubareaPlantSet class represents all the plant of same type in one
 * subarea.
 *
 * @author ZhipengChang
 */
public class GwiseSubareaPlantSet extends GwiseDataUnit {

    private final ObservableListWrapperA<GwiseLocationPlantSet> locationPlantSets;
    private final int plantSubgroupId;
    private final int subareaId;

    public GwiseSubareaPlantSet(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            List<GwiseLocationPlantSet> locationPlantSets, int plantSubgroupId, int subareaId) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.locationPlantSets = new ObservableListWrapperA<>(locationPlantSets);
        this.plantSubgroupId = plantSubgroupId;
        this.subareaId = subareaId;
    }

    public GwiseSubareaPlantSet(GwiseSubareaPlantSetBean bean) {
        super(bean);
        locationPlantSets = new ObservableListWrapperA<>();
        for (GwiseLocationPlantSetBean set : bean.getLocationPlantSets()) {
            locationPlantSets.add(new GwiseLocationPlantSet(set));
        }
        plantSubgroupId = bean.getPlantSubgroupId();
        subareaId = bean.getSubareaId();
    }

    @Override
    public GwiseSubareaPlantSetBean getBean() {

        return new GwiseSubareaPlantSetBean(this);
    }

    public ObservableListWrapperA<GwiseLocationPlantSet> getLocationPlantSets() {
        return locationPlantSets;
    }

    public int getPlantSubgroupId() {
        return plantSubgroupId;
    }

    public int getSubareaId() {
        return subareaId;
    }
}
