package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.presentation.PartDataModel;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.data.other.FertiliserDetailValueWrapper;
import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.FertiliserValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;

/**
 *
 * @author zc
 */
public abstract class AbstractFertiliserDataModel extends DataUnitFXMLDataModel<Fertiliser> {

    protected final FertiliserValueWrapper valueWrapper;
    private final ObservableListWrapperA<FertiliserType> types;
    protected final PartDataModel partModel;

    public AbstractFertiliserDataModel(FertiliserValueWrapper valueWrapper, FertiliserType...types) {
        this.valueWrapper = valueWrapper;
        this.types = new ObservableListWrapperA<>(types);
        partModel = getPartDataModel(getType().getValue());
    }
    
    public ObservableListWrapperA<FertiliserType> getTypes() {
        return types;
    }    
    
    public final ValueWrapper<FertiliserType> getType() {
        return valueWrapper.getType();
    }

    public ValueWrapper<String> getManufacturer() {
        return valueWrapper.getManufacturer();
    }

    public ValueWrapper<String> getSuggestedUsageAmount() {
        return valueWrapper.getSuggestedUsageAmount();
    }

    public ValueWrapper<String> getUsageUom() {
        return valueWrapper.getUsageUom();
    }

    public ValueWrapper<String> getPh() {
        return valueWrapper.getPh();
    }

    public ValueWrapper<String> getAluminium() {
        return valueWrapper.getAluminium();
    }

    public ValueWrapper<String> getBoron() {
        return valueWrapper.getBoron();
    }

    public ValueWrapper<String> getCalcium() {
        return valueWrapper.getCalcium();
    }

    public ValueWrapper<String> getChlorine() {
        return valueWrapper.getChlorine();
    }

    public ValueWrapper<String> getCobalt() {
        return valueWrapper.getCobalt();
    }

    public ValueWrapper<String> getCopper() {
        return valueWrapper.getCopper();
    }

    public ValueWrapper<String> getIron() {
        return valueWrapper.getIron();
    }

    public ValueWrapper<String> getMagnesium() {
        return valueWrapper.getMagnesium();
    }

    public ValueWrapper<String> getManganese() {
        return valueWrapper.getManganese();
    }

    public ValueWrapper<String> getMolybdenum() {
        return valueWrapper.getMolybdenum();
    }

    public ValueWrapper<String> getNitrogen() {
        return valueWrapper.getNitrogen();
    }

    public ValueWrapper<String> getNickel() {
        return valueWrapper.getNickel();
    }

    public ValueWrapper<String> getPhosphorus() {
        return valueWrapper.getPhosphorus();
    }

    public ValueWrapper<String> getPotassium() {
        return valueWrapper.getPotassium();
    }

    public ValueWrapper<String> getSelenium() {
        return valueWrapper.getSelenium();
    }

    public ValueWrapper<String> getSodium() {
        return valueWrapper.getSodium();
    }

    public ValueWrapper<String> getSulphur() {
        return valueWrapper.getSulphur();
    }

    public ValueWrapper<String> getVanadium() {
        return valueWrapper.getVanadium();
    }

    public ValueWrapper<String> getZinc() {
        return valueWrapper.getZinc();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/other/FertiliserFXML.fxml";
    }

    public final PartDataModel getPartDataModel(FertiliserType type) {
        switch (type) {
            case LIQUID:
                return new LiquidFertiliserDataModel(FertiliserFactory.getInstance().getDefaultLiquidFertiliserValueWrapper());
            case SOLID:
                return new SolidFertiliserDataModel(FertiliserFactory.getInstance().getDefaultSolidFertiliserValueWrapper());
            default:
                throw new IllegalStateException("Invalid fertiliser type.");
        }
    }

    public PartDataModel<FertiliserType, ? extends FertiliserDetailValueWrapper> getPartDataModel() {
        return partModel;
    }
}
