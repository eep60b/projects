package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGardenArea extends GwiseArea {

  //  private final ObservableListWrapperA <GwisePlantBed> plantBeds;
  //  private final ObservableListWrapperA<GwiseRaisedPlantBed> raisedPlantBeds;
    
    public GwiseGardenArea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
                AreaType type, List<GwiseSubarea> raisedPlantBeds) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, type, raisedPlantBeds);
 //       this.plantBeds = new ObservableListWrapperA<>(plantBeds);
 //       this.raisedPlantBeds = new ObservableListWrapperA<>(raisedPlantBeds);
    }

    public GwiseGardenArea(GwiseGardenAreaBean bean) {
        super(bean);
 //       plantBeds = new ObservableListWrapperA<>();
//        for(GwisePlantBedBean p : bean.getPlantBeds()) {
//            plantBeds.add(new GwisePlantBed(p));
//        }
//        
//        raisedPlantBeds = new ObservableListWrapperA<>();
        
    }

    @Override
    public AreaType getType() {
        return AreaType.GARDEN;
    }

    @Override
    public GwiseGardenAreaBean getBean() {
        return new GwiseGardenAreaBean(this);
    }

//    public ObservableListWrapperA<GwisePlantBed> getPlantBeds() {
//        return plantBeds;
//    }   
}
