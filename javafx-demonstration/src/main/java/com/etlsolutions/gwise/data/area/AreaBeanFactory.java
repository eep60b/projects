package com.etlsolutions.gwise.data.area;

/**
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

    public GwiseAreaBean getDefaultAreaBean(AreaType type) {

        switch (type) {
            case ALLOTMENT:
                return new GwiseAllotmentAreaBean();
            case BALCONY:
                return new GwiseBalconyAreaBean();
            case FARM:
                return new GwiseFarmAreaBean();
            case GARDEN:
                return new GwiseGardenAreaBean();
            case INDOOR:
                return new GwiseIndoorAreaBean();
            case PATIO:
                return new GwisePatioAreaBean();
            default:
                throw new IllegalStateException("Invalid area type.");
        }
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
