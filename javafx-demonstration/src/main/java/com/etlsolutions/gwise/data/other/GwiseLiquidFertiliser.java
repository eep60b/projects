package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.other.GwiseFertiliser;
import com.etlsolutions.javafx.data.ImageLink;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLiquidFertiliser extends GwiseFertiliser
{
    private boolean diluted;
    private double dilutionRatio;
    private String dilutionRatioUom;

    public GwiseLiquidFertiliser(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseLiquidFertiliser(GwiseDataUnitBean bean) {
        super(bean);
    }

    
    
    public boolean isDiluted() {
        return diluted;
    }

    public void setDiluted(boolean diluted) {
        this.diluted = diluted;
    }

    public double getDilutionRatio() {
        return dilutionRatio;
    }

    public void setDilutionRatio(double dilutionRatio) {
        this.dilutionRatio = dilutionRatio;
    }

    public String getDilutionRatioUom() {
        return dilutionRatioUom;
    }

    public void setDilutionRatioUom(String dilutionRatioUom) {
        this.dilutionRatioUom = dilutionRatioUom;
    }
    
    @Override
    public FertiliserType getType() {
        return FertiliserType.LIQUID;
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
