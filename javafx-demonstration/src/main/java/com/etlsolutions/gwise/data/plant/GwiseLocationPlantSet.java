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
    private final int parentId;
    private final int locationSetId;
    private final int plantTypeId;
    
    public GwiseLocationPlantSet(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, 
            List<GwisePlant> plants, int parentId, int locationSetId, int plantTypeId) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plants = new ObservableListWrapperA<>(plants);
        this.parentId = parentId;
        this.locationSetId = locationSetId;
        this.plantTypeId = plantTypeId;
    }

    public GwiseLocationPlantSet(GwiseLocationPlantSetBean bean) {
        super(bean);
        plants = new ObservableListWrapperA<>();
        for(GwisePlantBean plant : bean.getPlants()) {
            plants.add(new GwisePlant(plant));
        }
        parentId = bean.getSubareaPlantSetId();
        locationSetId = bean.getLocationSetId();
        plantTypeId = bean.getPlantTypeId();
    }

    @Override
    public GwiseLocationPlantSetBean getBean() {
        
        return new GwiseLocationPlantSetBean(this);
    }

    public ObservableListWrapperA<GwisePlant> getPlants() {
        return plants;
    }  

    public int getParentId() {
        return parentId;
    }

    public int getLocationSetId() {
        return locationSetId;
    }

    public int getPlantTypeId() {
        return plantTypeId;
    }
}
