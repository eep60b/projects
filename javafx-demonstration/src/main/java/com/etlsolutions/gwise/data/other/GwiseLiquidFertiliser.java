package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLiquidFertiliser extends GwiseFertiliser
{
    private final ValueWrapper<Boolean> dilutedWrapper;
    private final ValueWrapper<Double> dilutionRatioWrapper;
    private final ValueWrapper<String> dilutionRatioUomWrapper;

    public GwiseLiquidFertiliser(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, String manufacturer, String shop, double price, Date datePurchased, double suggestedUsageAmount, String usageUom, double aluminium, double boron, double calcium, double chlorine, double cobalt, double copper, double iron, double magnesium, double manganese, double molybdenum, double nitrogen, double nickel, double phosphorus, double potassium, double selenium, double sodium, double sulphur, double vanadium, double zinc, boolean diluted, double dilutionRatio, String dilutionRatioUom) {
        super(manufacturer, shop, price, datePurchased, suggestedUsageAmount, usageUom, aluminium, boron, calcium, chlorine, cobalt, copper, iron, magnesium, manganese, molybdenum, nitrogen, nickel, phosphorus, potassium, selenium, sodium, sulphur, vanadium, zinc, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        dilutedWrapper = new ValueWrapper<>(diluted);
        dilutionRatioWrapper = new ValueWrapper<>(dilutionRatio);
        dilutionRatioUomWrapper = new ValueWrapper<>(dilutionRatioUom);
    }

    public GwiseLiquidFertiliser(GwiseLiquidFertiliserBean bean) {
        super(bean);
        dilutedWrapper = new ValueWrapper<>(bean.isDiluted()); 
        dilutionRatioWrapper = new ValueWrapper<>(bean.getDilutionRatio());        
        dilutionRatioUomWrapper = new ValueWrapper<>(bean.getDilutionRatioUom());
    }

    public ValueWrapper<Boolean> getDilutedWrapper() {
        return dilutedWrapper;
    }
    
    public boolean isDiluted() {
        return dilutedWrapper.getValue();
    }

    public void setDiluted(boolean diluted) {
        dilutedWrapper.setValue(diluted);
    }

    public ValueWrapper<Double> getDilutionRatioWrapper() {
        return dilutionRatioWrapper;
    }

    public double getDilutionRatio() {
        return dilutionRatioWrapper.getValue();
    }

    public void setDilutionRatio(double dilutionRatio) {
        dilutionRatioWrapper.setValue(dilutionRatio);
    }

    public ValueWrapper<String> getDilutionRatioUomWrapper() {
        return dilutionRatioUomWrapper;
    }

    public String getDilutionRatioUom() {
        return dilutionRatioUomWrapper.getValue();
    }

    public void setDilutionRatioUom(String dilutionRatioUom) {
        dilutionRatioUomWrapper.setValue(dilutionRatioUom);
    }
    
    @Override
    public FertiliserType getType() {
        return FertiliserType.LIQUID;
    }

    @Override
    public GwiseLiquidFertiliserBean getBean() {
        return new GwiseLiquidFertiliserBean(this);
    }
}
