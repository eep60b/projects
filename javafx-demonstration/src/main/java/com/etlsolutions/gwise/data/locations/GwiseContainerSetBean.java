package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseContainerSetBean extends GwiseDataUnitBean {

    private int parentId;
    private int plantSubgroupId;
    private List<GwiseContainerBean> containers;
    
    public GwiseContainerSetBean() {
    }

    public GwiseContainerSetBean(GwiseContainerSet set) {
        super(set);
        parentId = set.getParent().getId();
        plantSubgroupId = set.getPlantSubgroup().getId();
        containers = new ArrayList<>();
        for(GwiseContainer c : set.getContainers()) {
            containers.add(new GwiseContainerBean(c));
        }
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPlantSubgroupId() {
        return plantSubgroupId;
    }

    public void setPlantSubgroupId(int plantSubgroupId) {
        this.plantSubgroupId = plantSubgroupId;
    }

    public List<GwiseContainerBean> getContainers() {
        return containers;
    }

    public void setContainers(List<GwiseContainerBean> containers) {
        this.containers = containers;
    }
}
