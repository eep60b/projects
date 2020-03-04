package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.locations.GwiseContainerSet;
import com.etlsolutions.gwise.data.locations.GwiseContainerSetBean;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseContainerSubarea extends GwiseSubarea {

    private final ObservableListWrapperA<GwiseContainerSet> containerSets;

    public GwiseContainerSubarea(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, GwiseArea parent, GwisePoint referencePoint,
            List<GwiseContainerSet> containerSets) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, parent, referencePoint);
        this.containerSets = new ObservableListWrapperA<>(containerSets);        
    }

    public GwiseContainerSubarea(GwiseContainerSubareaBean bean) {
        super(bean);
        containerSets = new ObservableListWrapperA<>();
        for(GwiseContainerSetBean set : bean.getContainerSets()) {
            containerSets.add(new GwiseContainerSet(set));
        }
    }
    
    @Override
    public GwiseContainerSubareaBean getBean() {
        return new GwiseContainerSubareaBean(this);
    }

    public ObservableListWrapperA<GwiseContainerSet> getContainerSets() {
        return containerSets;
    }    
}
