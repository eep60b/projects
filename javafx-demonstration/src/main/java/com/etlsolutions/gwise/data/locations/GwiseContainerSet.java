package com.etlsolutions.gwise.data.locations;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.plant.GwisePlantSubgroup;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.List;

/**
 * The GwiseContainerSet class 
 * @author ZhipengChang
 */
public class GwiseContainerSet extends GwiseDataUnit {

    private final GwiseSubarea parent;
    private final GwisePlantSubgroup plantSubgroup;
    private final ObservableListWrapperA<GwiseContainer> containers;    
    
    public GwiseContainerSet(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, 
            GwiseSubarea parent, GwisePlantSubgroup plantSubgroup, List<GwiseContainer> containers) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.parent = parent;
        this.plantSubgroup = plantSubgroup;
        this.containers = new ObservableListWrapperA<>(containers);
        
    }

    public GwiseContainerSet(GwiseContainerSetBean bean) {
        super(bean);
        parent = ProjectManager.getInstance().getGwiseItem(bean.getParentId());
        plantSubgroup = ProjectManager.getInstance().getGwiseItem(bean.getPlantSubgroupId());
        containers = new ObservableListWrapperA<>();
        for(GwiseContainerBean c : bean.getContainers()) {
            containers.add(new GwiseContainer(c));
        }
    }

    @Override
    public GwiseContainerSetBean getBean() {
        return new GwiseContainerSetBean(this);
    }

    public GwiseSubarea getParent() {
        return parent;
    }

    public GwisePlantSubgroup getPlantSubgroup() {
        return plantSubgroup;
    }

    public ObservableListWrapperA<GwiseContainer> getContainers() {
        return containers;
    }
}
