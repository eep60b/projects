package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.plant.GwiseSubareaPlantSet;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.List;

/**
 * 
 * @author ZhipengChang
 */
public class GwisePlantSubgroupLocationSet extends GwiseDataUnit {

    private final GwiseSubarea parent;
    private final GwiseSubareaPlantSet plantSet;
    private final ObservableListWrapperA<GwiseLocationSet> locationSets;    

    public GwisePlantSubgroupLocationSet(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            GwiseSubarea parent, GwiseSubareaPlantSet plantSet, List<GwiseLocationSet> locationSets) {
        
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.parent = parent;
        this.plantSet = plantSet;
        this.locationSets = new ObservableListWrapperA<>(locationSets);
    }

    public GwisePlantSubgroupLocationSet(GwisePlantSubgroupLocationSetBean bean) {
        super(bean);
        parent = ProjectManager.getInstance().getGwiseItem(bean.getParentId());
        plantSet = ProjectManager.getInstance().getGwiseItem(bean.getPlantSetId());
        this.locationSets = new ObservableListWrapperA<>();
        for(GwiseLocationSetBean l : bean.getLocationSets()) {
            this.locationSets.add(new GwiseLocationSet(l));
        }
    }
    
    @Override
    public GwisePlantSubgroupLocationSetBean getBean() {
        return new GwisePlantSubgroupLocationSetBean(this);
    }

    public GwiseSubarea getParent() {
        return parent;
    }
    
    public GwiseSubareaPlantSet getPlantSet() {
        return plantSet;
    }

    public ObservableListWrapperA<GwiseLocationSet> getLocationSets() {
        return locationSets;
    }    
}
