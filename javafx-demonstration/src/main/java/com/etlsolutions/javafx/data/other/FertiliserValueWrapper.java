package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class FertiliserValueWrapper extends DataUnitValueWrapper {

    private final ValueWrapper<FertiliserType> type;
    private final ValueWrapper<String> manufacturer;
    private final ValueWrapper<String> suggestedUsageAmount;
    private final ValueWrapper<String> usageUom;
    private final ValueWrapper<String> ph;
    private final ValueWrapper<String> aluminium;
    private final ValueWrapper<String> boron;
    private final ValueWrapper<String> calcium;
    private final ValueWrapper<String> chlorine;
    private final ValueWrapper<String> cobalt;
    private final ValueWrapper<String> copper;
    private final ValueWrapper<String> iron;
    private final ValueWrapper<String> magnesium;
    private final ValueWrapper<String> manganese;
    private final ValueWrapper<String> molybdenum;
    private final ValueWrapper<String> nitrogen;
    private final ValueWrapper<String> nickel;
    private final ValueWrapper<String> phosphorus;
    private final ValueWrapper<String> potassium;
    private final ValueWrapper<String> selenium;
    private final ValueWrapper<String> sodium;
    private final ValueWrapper<String> sulphur;
    private final ValueWrapper<String> vanadium;
    private final ValueWrapper<String> zinc;
    
    public FertiliserValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, FertiliserType type, String manufacturer, double suggestedUsageAmount, String usageUom, double ph, double aluminium, double boron, double calcium, double chlorine, double cobalt, double copper, double iron, double magnesium, double manganese, double molybdenum, double nitrogen, double nickel, double phosphorus, double potassium, double selenium, double sodium, double sulphur, double vanadium, double zinc) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.type = new ValueWrapper<>(type);
        this.manufacturer = new ValueWrapper<>(manufacturer);
        this.suggestedUsageAmount = new ValueWrapper<>(String.valueOf(suggestedUsageAmount));
        this.usageUom = new ValueWrapper<>(usageUom);
        this.ph = new ValueWrapper<>(String.valueOf(ph));
        this.aluminium = getWrapper(aluminium);
        this.boron = new ValueWrapper<>(String.valueOf(boron));
        this.calcium = new ValueWrapper<>(String.valueOf(calcium));
        this.chlorine = new ValueWrapper<>(String.valueOf(chlorine));
        this.cobalt = new ValueWrapper<>(String.valueOf(cobalt));
        this.copper = new ValueWrapper<>(String.valueOf(copper));
        this.iron = new ValueWrapper<>(String.valueOf(iron));
        this.magnesium = new ValueWrapper<>(String.valueOf(magnesium));
        this.manganese = new ValueWrapper<>(String.valueOf(manganese));
        this.molybdenum = new ValueWrapper<>(String.valueOf(molybdenum));
        this.nitrogen = new ValueWrapper<>(String.valueOf(nitrogen));
        this.nickel = new ValueWrapper<>(String.valueOf(nickel));
        this.phosphorus = new ValueWrapper<>(String.valueOf(phosphorus));
        this.potassium = new ValueWrapper<>(String.valueOf(potassium));
        this.selenium = new ValueWrapper<>(String.valueOf(selenium));
        this.sodium = new ValueWrapper<>(String.valueOf(sodium));
        this.sulphur = new ValueWrapper<>(String.valueOf(sulphur));
        this.vanadium = new ValueWrapper<>(String.valueOf(vanadium));
        this.zinc = new ValueWrapper<>(String.valueOf(zinc));
    }

    public FertiliserValueWrapper(Fertiliser fertiliser) {
        super(fertiliser);
        type = new ValueWrapper<>(fertiliser.getType());
        manufacturer = new ValueWrapper<>(fertiliser.getManufacturer());
        suggestedUsageAmount = getWrapper(fertiliser.getSuggestedUsageAmount());
        usageUom = new ValueWrapper<>(fertiliser.getUsageUom());
        ph = getWrapper(fertiliser.getPh());
        aluminium = getWrapper(fertiliser.getAluminium());
        boron = getWrapper(fertiliser.getBoron());
        calcium = getWrapper(fertiliser.getCalcium());
        chlorine = getWrapper(fertiliser.getChlorine());
        cobalt = getWrapper(fertiliser.getCobalt());
        copper = getWrapper(fertiliser.getCopper());
        iron = getWrapper(fertiliser.getIron());
        magnesium = getWrapper(fertiliser.getMagnesium());
        manganese = getWrapper(fertiliser.getManganese());
        molybdenum = getWrapper(fertiliser.getMolybdenum());
        nitrogen = getWrapper(fertiliser.getNitrogen());
        nickel = getWrapper(fertiliser.getNickel());
        phosphorus = getWrapper(fertiliser.getPhosphorus());
        potassium = getWrapper(fertiliser.getPotassium());
        selenium = getWrapper(fertiliser.getSelenium());
        sodium = getWrapper(fertiliser.getSodium());
        sulphur = getWrapper(fertiliser.getSulphur());
        vanadium = getWrapper(fertiliser.getVanadium());
        zinc = getWrapper(fertiliser.getZinc());
    }

    public ValueWrapper<FertiliserType> getType() {
        return type;
    }
    
    public ValueWrapper<String> getManufacturer() {
        return manufacturer;
    }

    public ValueWrapper<String> getSuggestedUsageAmount() {
        return suggestedUsageAmount;
    }

    public ValueWrapper<String> getUsageUom() {
        return usageUom;
    }

    public ValueWrapper<String> getPh() {
        return ph;
    }

    public ValueWrapper<String> getAluminium() {
        return aluminium;
    }

    public ValueWrapper<String> getBoron() {
        return boron;
    }

    public ValueWrapper<String> getCalcium() {
        return calcium;
    }

    public ValueWrapper<String> getChlorine() {
        return chlorine;
    }

    public ValueWrapper<String> getCobalt() {
        return cobalt;
    }

    public ValueWrapper<String> getCopper() {
        return copper;
    }

    public ValueWrapper<String> getIron() {
        return iron;
    }

    public ValueWrapper<String> getMagnesium() {
        return magnesium;
    }

    public ValueWrapper<String> getManganese() {
        return manganese;
    }

    public ValueWrapper<String> getMolybdenum() {
        return molybdenum;
    }

    public ValueWrapper<String> getNitrogen() {
        return nitrogen;
    }

    public ValueWrapper<String> getNickel() {
        return nickel;
    }

    public ValueWrapper<String> getPhosphorus() {
        return phosphorus;
    }

    public ValueWrapper<String> getPotassium() {
        return potassium;
    }

    public ValueWrapper<String> getSelenium() {
        return selenium;
    }

    public ValueWrapper<String> getSodium() {
        return sodium;
    }

    public ValueWrapper<String> getSulphur() {
        return sulphur;
    }

    public ValueWrapper<String> getVanadium() {
        return vanadium;
    }

    public ValueWrapper<String> getZinc() {
        return zinc;
    }
}
