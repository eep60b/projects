package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.locations.GwiseContainerSet;
import com.etlsolutions.gwise.data.locations.GwiseContainerSetBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseContainerSubareaBean extends GwiseSubareaBean {

    private List<GwiseContainerSetBean> containerSets;
    
    public GwiseContainerSubareaBean() {
    }

    public GwiseContainerSubareaBean(GwiseContainerSubarea subarea) {
        super(subarea);
        containerSets = new ArrayList<>();
        for(GwiseContainerSet set : subarea.getContainerSets()) {
            containerSets.add(new GwiseContainerSetBean(set));
        }
    }

    public List<GwiseContainerSetBean> getContainerSets() {
        return containerSets;
    }

    public void setContainerSets(List<GwiseContainerSetBean> containerSets) {
        this.containerSets = containerSets;
    }
}
