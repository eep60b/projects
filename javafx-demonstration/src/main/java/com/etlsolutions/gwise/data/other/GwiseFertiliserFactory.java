package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.DataUnitIdRegistry;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Zhipeng
 */
public class GwiseFertiliserFactory {

    private static final GwiseFertiliserFactory INSTANCE = new GwiseFertiliserFactory();

    private GwiseFertiliserFactory() {
    }

    public static GwiseFertiliserFactory getInstance() {
        return new GwiseFertiliserFactory();
    }

    public GwiseFertiliser getDefaultFertiliser() {
        return getDefaultFertiliser(FertiliserType.SOLID);
    }

    public GwiseFertiliser getDefaultFertiliser(FertiliserType fertiliserType) {
        switch (fertiliserType) {
            case SOLID:
                return new GwiseSolidFertiliser(DataUnitIdRegistry.getInstance().createNewId(), "untitled", "", new ArrayList<ImageLink>(), 0, "", "Not specified", "Not specified", 0, new Date(), 0, "", 7.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7.0, 0, 7.0, 7.0, 0, 0, 0, 0, 0, 0, "g");
            case LIQUID:
                return new GwiseLiquidFertiliser(DataUnitIdRegistry.getInstance().createNewId(), "untitled", "", new ArrayList<ImageLink>(), 0, "", "Not specified", "Not specified", 0, new Date(), 0, "", 7.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7.0, 0, 7.0, 7.0, 0, 0, 0, 0, 0, true, 0, "ml/L");
                default:
                    throw new IllegalStateException("Invalid fertiliser type: " + fertiliserType);
        }
    }

    public GwiseFertiliser getFertiliser(GwiseFertiliserBean bean) {

        switch (bean.getType()) {
            case LIQUID:
                return new GwiseLiquidFertiliser((GwiseLiquidFertiliserBean) bean);
            case SOLID:
                return new GwiseSolidFertiliser((GwiseSolidFertiliserBean) bean);
            default:
                throw new IllegalStateException("Invalid GwiseFertiliserBean object: " + bean);
        }
    }

    public ObservableListWrapperA<String> getDefaultFertiliserUoms() {
        return new ObservableListWrapperA<>("g", "kg", "litre", "ml", "ounce", "pound", "gallon");
    }
}
