package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseSolidFertiliser extends GwiseFertiliser {

    private final ValueWrapper<Double> densityWrapper;
    private String densityUom;

    public GwiseSolidFertiliser(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, String manufacturer, String shop, double price, Date datePurchased, double suggestedUsageAmount, String usageUom, double aluminium, double boron, double calcium, double chlorine, double cobalt, double copper, double iron, double magnesium, double manganese, double molybdenum, double nitrogen, double nickel, double phosphorus, double potassium, double selenium, double sodium, double sulphur, double vanadium, double zinc, double density, String densityUom) {
        super(manufacturer, shop, price, datePurchased, suggestedUsageAmount, usageUom, aluminium, boron, calcium, chlorine, cobalt, copper, iron, magnesium, manganese, molybdenum, nitrogen, nickel, phosphorus, potassium, selenium, sodium, sulphur, vanadium, zinc, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        densityWrapper = new ValueWrapper<>(density);
        this.densityUom = densityUom;
    }
    
    public GwiseSolidFertiliser(GwiseSolidFertiliserBean bean) {
        super(bean);
        densityWrapper = new ValueWrapper<>(bean.getDensity());
    }

    public ValueWrapper<Double> getDensityWrapper() {
        return densityWrapper;
    }
    
    public double getDensity() {
        return densityWrapper.getValue();
    }

    public void setDensity(double density) {
        densityWrapper.setValue(density);
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
    public GwiseSolidFertiliserBean getBean() {
        return new GwiseSolidFertiliserBean(this);
    }
}
