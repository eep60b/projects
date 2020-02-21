package com.etlsolutions.javafx.presentation.dialog.fertiliser;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.presentation.PartDataModel;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.gwise.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.FertiliserValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.data.other.FertiliserSpecialValueWrapper;

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

    public AbstractFertiliserDataModel(Fertiliser fertiliser, FertiliserValueWrapper valueWrapper, FertiliserType...types) {
        set(fertiliser);
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

    @Override
    protected FertiliserValueWrapper getValueWrapper() {
      return valueWrapper;   
    }

    
    public final PartDataModel getPartDataModel(FertiliserType type) {
        switch (type) {
            case LIQUID:
                return new LiquidFertiliserPartDataModel(FertiliserFactory.getInstance().getDefaultLiquidFertiliserValueWrapper());
            case SOLID:
                return new SolidFertiliserPartDataModel(FertiliserFactory.getInstance().getDefaultSolidFertiliserValueWrapper());
            default:
                throw new IllegalStateException("Invalid fertiliser type.");
        }
    }

    public PartDataModel<FertiliserType, ? extends FertiliserSpecialValueWrapper> getPartDataModel() {
        return partModel;
    }
}
