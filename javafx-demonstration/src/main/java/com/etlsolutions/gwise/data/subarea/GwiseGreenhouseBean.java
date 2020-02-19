package com.etlsolutions.gwise.data.subarea;

import com.etlsolutions.gwise.data.basicshape.GwiseShapeBean;
import com.etlsolutions.gwise.data.locations.GwiseContainerSetBean;
import com.etlsolutions.gwise.data.locations.GwisePlantSubgroupLocationSetBean;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGreenhouseBean extends GwiseSubareaBean {

    private GwiseShapeBean shapeBean;
    private List<GwisePlantSubgroupLocationSetBean> plantSubgroupLocationSetBeans;
    private List<GwiseContainerSetBean> containerSetBeans;    
    
    public GwiseGreenhouseBean() {
    }

    public GwiseGreenhouseBean(GwiseGreenhouse greenhouse) {
        super(greenhouse);
    }

    public GwiseShapeBean getShapeBean() {
        return shapeBean;
    }

    public void setShapeBean(GwiseShapeBean shapeBean) {
        this.shapeBean = shapeBean;
    }

    public List<GwisePlantSubgroupLocationSetBean> getPlantSubgroupLocationSetBeans() {
        return plantSubgroupLocationSetBeans;
    }

    public void setPlantSubgroupLocationSetBeans(List<GwisePlantSubgroupLocationSetBean> plantSubgroupLocationSetBeans) {
        this.plantSubgroupLocationSetBeans = plantSubgroupLocationSetBeans;
    }

    public List<GwiseContainerSetBean> getContainerSetBeans() {
        return containerSetBeans;
    }

    public void setContainerSetBeans(List<GwiseContainerSetBean> containerSetBeans) {
        this.containerSetBeans = containerSetBeans;
    }
}
