package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.subarea.GwisePlantBed;
import com.etlsolutions.gwise.data.subarea.GwisePlantBedBean;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGardenArea extends GwiseArea {

    private final ObservableListWrapperA <GwisePlantBed> plantBeds;
    public GwiseGardenArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
                List<GwisePlantBed> plantBeds) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plantBeds = new ObservableListWrapperA<>(plantBeds);
    }

    public GwiseGardenArea(GwiseGardenAreaBean bean) {
        super(bean);
        plantBeds = new ObservableListWrapperA<>();
        for(GwisePlantBedBean p : bean.getPlantBeds()) {
            plantBeds.add(new GwisePlantBed(p));
        }
    }

    @Override
    public AreaType getType() {
        return AreaType.GARDEN;
    }

    @Override
    public GwiseGardenAreaBean getBean() {
        return new GwiseGardenAreaBean(this);
    }

    public ObservableListWrapperA<GwisePlantBed> getPlantBeds() {
        return plantBeds;
    }   
}
