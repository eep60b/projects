package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantGroup extends GwiseDataUnit {

    private final ObservableListWrapperA<GwisePlantSubgroup> plantSubgroups;
    private final ObservableListWrapperA<PlantType> plantTypes;

    public GwisePlantGroup(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            List<GwisePlantSubgroup> plantSubgroups, List<PlantType> plantTypes) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plantSubgroups = new ObservableListWrapperA<>(plantSubgroups);
        this.plantTypes = new ObservableListWrapperA<>(plantTypes);
    }

    public GwisePlantGroup(GwisePlantGroupBean bean) {
        super(bean);
        plantSubgroups = new ObservableListWrapperA<>();
        for (GwisePlantSubgroupBean subgroup : bean.getPlantSubgroupBeans()) {
            plantSubgroups.add(new GwisePlantSubgroup(subgroup));
        }
        
        plantTypes = new ObservableListWrapperA<>();
        for(PlantTypeBean type : bean.getPlantTypeBeans()) {
            plantTypes.add(new PlantType(type));
        }
        
    }

    @Override
    public GwisePlantGroupBean getBean() {
        return new GwisePlantGroupBean(this);
    }

    public ObservableListWrapperA<GwisePlantSubgroup> getPlantSubgroups() {
        return plantSubgroups;
    }

    public ObservableListWrapperA<PlantType> getPlantTypes() {
        return plantTypes;
    }
    
}
