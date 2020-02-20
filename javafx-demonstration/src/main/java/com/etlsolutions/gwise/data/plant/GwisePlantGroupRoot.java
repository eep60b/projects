package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantGroupRoot extends GwiseDataUnit {

    private final ObservableListWrapperA<GwisePlantGroup> plantGroups;

    public GwisePlantGroupRoot(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwisePlantGroup> plantGroups) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plantGroups = new ObservableListWrapperA<>(plantGroups);
    }    

    public GwisePlantGroupRoot(GwisePlantGroupRootBean root) {
        super(root.getId(), root.getTitle(), root.getInformation(), root.getImageLinks(), root.getSelectedImgLinkIndex(), root.getLogoPath());
        this.plantGroups = new ObservableListWrapperA<>();        
        for(GwisePlantGroupBean group : root.getPlantGroups()) {
            this.plantGroups.add(new GwisePlantGroup(group));
        }
    }

    @Override
    public GwisePlantGroupRootBean getBean() {
        return new GwisePlantGroupRootBean(this);
    }

    public ObservableListWrapperA<GwisePlantGroup> getPlantGroups() {
        return plantGroups;
    }
}
