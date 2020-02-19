package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.basicshape.GwiseShape;
import com.etlsolutions.gwise.data.basicshape.ShapeUtils;
import com.etlsolutions.gwise.data.locations.GwiseContainerSet;
import com.etlsolutions.gwise.data.locations.GwiseContainerSetBean;
import com.etlsolutions.gwise.data.locations.GwisePlantSubgroupLocationSet;
import com.etlsolutions.gwise.data.locations.GwisePlantSubgroupLocationSetBean;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGreenhouse extends GwiseSubarea {

    private final GwiseShape shape;
    private final ObservableListWrapperA<GwisePlantSubgroupLocationSet> plantSubgroupLocationSets;
    private final ObservableListWrapperA<GwiseContainerSet> containerSets;      
    
    public GwiseGreenhouse(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, GwiseArea parent, GwisePoint referencePoint,
            GwiseShape shape, List<GwisePlantSubgroupLocationSet> plantSubgroupLocationSets, List<GwiseContainerSet> containerSets) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, parent, referencePoint);
        this.shape = shape;
        this.plantSubgroupLocationSets = new ObservableListWrapperA<>(plantSubgroupLocationSets);
        this.containerSets = new ObservableListWrapperA<>(containerSets);
    }

    public GwiseGreenhouse(GwiseGreenhouseBean bean) {
        super(bean);
        shape = ShapeUtils.getInstance().getShape(bean.getShapeBean());
        plantSubgroupLocationSets = new ObservableListWrapperA<>();
        for(GwisePlantSubgroupLocationSetBean set : bean.getPlantSubgroupLocationSetBeans()) {
            plantSubgroupLocationSets.add(new GwisePlantSubgroupLocationSet(set));
        }
        containerSets = new ObservableListWrapperA<>();
        for(GwiseContainerSetBean set : bean.getContainerSetBeans()) {
            containerSets.add(new GwiseContainerSet(set));
        }
    }
    
    @Override
    public GwiseGreenhouseBean getBean() {
        return new GwiseGreenhouseBean(this);
    }

    public GwiseShape getShape() {
        return shape;
    }

    public ObservableListWrapperA<GwisePlantSubgroupLocationSet> getPlantSubgroupLocationSets() {
        return plantSubgroupLocationSets;
    }

    public ObservableListWrapperA<GwiseContainerSet> getContainerSets() {
        return containerSets;
    }    
}
