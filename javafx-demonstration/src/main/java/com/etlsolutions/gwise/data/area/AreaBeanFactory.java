package com.etlsolutions.gwise.data.area;

import com.etlsolutions.gwise.data.DataUnitIdRegistry;
import com.etlsolutions.gwise.data.subarea.GwisePlantBedBean;

/**
 * The AreaBeanFactory class is a factory class which create new objects for area related items.
 *
 * @author ZhipengChang
 */
public class AreaBeanFactory {

    private static final AreaBeanFactory INSTANCE = new AreaBeanFactory();

    private AreaBeanFactory() {
    }

    public static AreaBeanFactory getInstance() {
        return INSTANCE;
    }

    public GwiseAreaRootBean createGwiseAreaRootBean() {
        GwiseAreaRootBean bean = new GwiseAreaRootBean();
        bean.setId(DataUnitIdRegistry.getInstance().createNewId());
        bean.setTitle("All Areas");
        return bean;
    }

    public GwiseGardenAreaBean createDefaultGardenAreaBean() {

        GwiseGardenAreaBean bean = new GwiseGardenAreaBean();
        bean.setTitle("My Garden");
        bean.setId(DataUnitIdRegistry.getInstance().createNewId());
        return bean;
    }

    public GwisePlantBedBean createDefaultPlantBedBean () {
        GwisePlantBedBean bean = new GwisePlantBedBean();
        bean.setTitle("My Plant Bed");
        bean.setId(DataUnitIdRegistry.getInstance().createNewId());
        return bean;        
    }
    
    public GwiseAreaBean getDefaultAreaBean(AreaType type) {

        GwiseAreaBean bean;
        switch (type) {
            case ALLOTMENT:
                bean = new GwiseAllotmentAreaBean();
                break;
            case BALCONY:
                bean = new GwiseBalconyAreaBean();
                break;
            case FARM:
                bean = new GwiseFarmAreaBean();
                break;
            case GARDEN:
                bean = new GwiseGardenAreaBean();
                bean.setTitle("My Garden");
                break;
            case INDOOR:
                bean = new GwiseIndoorAreaBean();
                break;
            case PATIO:
                bean = new GwisePatioAreaBean();
                break;
            default:
                throw new IllegalStateException("Invalid area type.");
        }

        bean.setId(DataUnitIdRegistry.getInstance().createNewId());
        return bean;
    }

    public GwiseAreaBean getAreaBean(GwiseArea area) {

        switch (area.getType()) {
            case ALLOTMENT:
                return new GwiseAllotmentAreaBean((GwiseAllotmentArea) area);
            case BALCONY:
                return new GwiseBalconyAreaBean((GwiseBalconyArea) area);
            case FARM:
                return new GwiseFarmAreaBean((GwiseFarmArea) area);
            case GARDEN:
                return new GwiseGardenAreaBean((GwiseGardenArea) area);
            case INDOOR:
                return new GwiseIndoorAreaBean((GwiseIndoorArea) area);
            case PATIO:
                return new GwisePatioAreaBean((GwisePatioArea) area);
            default:
                throw new IllegalStateException("Invalid area type.");
        }
    }
}
