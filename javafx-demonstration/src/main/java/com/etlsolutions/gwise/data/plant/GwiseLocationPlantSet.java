package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLocationPlantSet extends GwiseDataUnit {

    private final ObservableListWrapperA<GwisePlant> plants;
    private final int subareaPlantSetId;
    private final int locationSetId;
    
    public GwiseLocationPlantSet(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, 
            List<GwisePlant> plants, int subareaPlantSetId, int locationSetId) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plants = new ObservableListWrapperA<>(plants);
        this.subareaPlantSetId = subareaPlantSetId;
        this.locationSetId = locationSetId;
    }

    public GwiseLocationPlantSet(GwiseLocationPlantSetBean bean) {
        super(bean);
        plants = new ObservableListWrapperA<>();
        for(GwisePlantBean plant : bean.getPlants()) {
            plants.add(new GwisePlant(plant));
        }
        subareaPlantSetId = bean.getSubareaPlantSetId();
        locationSetId = bean.getLocationSetId();
    }

    @Override
    public GwiseLocationPlantSetBean getBean() {
        
        return new GwiseLocationPlantSetBean(this);
    }

    public ObservableListWrapperA<GwisePlant> getPlants() {
        return plants;
    }  

    public int getSubareaPlantSetId() {
        return subareaPlantSetId;
    }

    public int getLocationSetId() {
        return locationSetId;
    }
}
