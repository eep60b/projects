package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.javafx.data.ImageLink;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseSolidFertiliser extends GwiseFertiliser {

    private double density;
    private String densityUom;

    public GwiseSolidFertiliser(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseSolidFertiliser(GwiseDataUnitBean bean) {
        super(bean);
    }

    
    
    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getDensityUom() {
        return densityUom;
    }

    public void setDensityUom(String densityUom) {
        this.densityUom = densityUom;
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
