package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
public abstract class GwiseFertiliser extends GwiseDataUnit {

    private final ValueWrapper<String> manufacturerWrapper;
    private final ValueWrapper<String> shopWrapper;
    private final ValueWrapper<Double> priceWrapper;
    private final ObservableListWrapperA webLinks;
    private final ValueWrapper<Date> datePurchasedWrapper;
    private final ValueWrapper<Double> suggestedUsageAmountWrapper;
    private final ValueWrapper<String> usageUomWrapper;
    private final ValueWrapper<Double> phWrapper;
    private final ValueWrapper<Double> aluminiumWrapper;
    private final ValueWrapper<Double> boronWrapper;
    private final ValueWrapper<Double> calciumWrapper;
    private final ValueWrapper<Double> chlorineWrapper;
    private final ValueWrapper<Double> cobaltWrapper;
    private final ValueWrapper<Double> copperWrapper;
    private final ValueWrapper<Double> ironWrapper;
    private final ValueWrapper<Double> magnesiumWrapper;
    private final ValueWrapper<Double> manganeseWrapper;
    private final ValueWrapper<Double> molybdenumWrapper;
    private final ValueWrapper<Double> nitrogenWrapper;
    private final ValueWrapper<Double> nickelWrapper;
    private final ValueWrapper<Double> phosphorusWrapper;
    private final ValueWrapper<Double> potassiumWrapper;
    private final ValueWrapper<Double> seleniumWrapper;
    private final ValueWrapper<Double> sodiumWrapper;
    private final ValueWrapper<Double> sulphurWrapper;
    private final ValueWrapper<Double> vanadiumWrapper;
    private final ValueWrapper<Double> zincWrapper;

    public GwiseFertiliser(String manufaucturer, String shop, List<String> webLinks, double price, Date datePurchased, double suggestedUsageAmount, String usageUom, double ph, double aluminium, double boron, double calcium, double chlorine, double cobalt, double copper, double iron, double magnesium, double manganese, double molybdenum, double nitrogen, double nickel, double phosphorus, double potassium, double selenium, double sodium, double sulphur, double vanadium, double zinc, int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        manufacturerWrapper = new ValueWrapper<>(manufaucturer);
        shopWrapper = new ValueWrapper<>(shop);
        this.webLinks = new ObservableListWrapperA(webLinks);
        priceWrapper = new ValueWrapper<>(price);
        datePurchasedWrapper = new ValueWrapper<>(datePurchased);
        suggestedUsageAmountWrapper = new ValueWrapper<>(suggestedUsageAmount);
        usageUomWrapper = new ValueWrapper<>(usageUom);
        phWrapper = new ValueWrapper<>(ph);
        aluminiumWrapper = new ValueWrapper<>(aluminium);
        boronWrapper = new ValueWrapper<>(boron);
        calciumWrapper = new ValueWrapper<>(calcium);
        chlorineWrapper = new ValueWrapper<>(chlorine);
        cobaltWrapper = new ValueWrapper<>(cobalt);
        copperWrapper = new ValueWrapper<>(copper);
        ironWrapper = new ValueWrapper<>(iron);
        magnesiumWrapper = new ValueWrapper<>(magnesium);
        manganeseWrapper = new ValueWrapper<>(manganese);
        molybdenumWrapper = new ValueWrapper<>(molybdenum);
        nitrogenWrapper = new ValueWrapper<>(nitrogen);
        nickelWrapper = new ValueWrapper<>(nickel);
        phosphorusWrapper = new ValueWrapper<>(phosphorus);
        potassiumWrapper = new ValueWrapper<>(potassium);
        seleniumWrapper = new ValueWrapper<>(selenium);
        sodiumWrapper = new ValueWrapper<>(sodium);
        sulphurWrapper = new ValueWrapper<>(sulphur);
        vanadiumWrapper = new ValueWrapper<>(vanadium);
        zincWrapper = new ValueWrapper<>(zinc);
    }

    public GwiseFertiliser(GwiseFertiliserBean bean) {
        super(bean);
        manufacturerWrapper = new ValueWrapper<>(bean.getManufacturer());
        shopWrapper = new ValueWrapper<>(bean.getShop());
        webLinks = new ObservableListWrapperA(); 
        for(String webLink : bean.getWebLinks()) {
          webLinks.add(webLink);
        }
        priceWrapper = new ValueWrapper<>(bean.getPrice());
        datePurchasedWrapper = new ValueWrapper<>(bean.getDatePurchased());
        suggestedUsageAmountWrapper = new ValueWrapper<>(bean.getSuggestedUsageAmount());
        usageUomWrapper = new ValueWrapper<>(bean.getUsageUom());
        phWrapper = new ValueWrapper<>(bean.getPh());
        aluminiumWrapper = new ValueWrapper<>(bean.getAluminium());
        boronWrapper = new ValueWrapper<>(bean.getBoron());
        calciumWrapper = new ValueWrapper<>(bean.getCalcium());     
        chlorineWrapper = new ValueWrapper<>(bean.getChlorine());
        cobaltWrapper = new ValueWrapper<>(bean.getCobalt());
        copperWrapper = new ValueWrapper<>(bean.getCopper());
        ironWrapper = new ValueWrapper<>(bean.getIron());
        magnesiumWrapper = new ValueWrapper<>(bean.getMagnesium());
        manganeseWrapper = new ValueWrapper<>(bean.getManganese());
        molybdenumWrapper = new ValueWrapper<>(bean.getMolybdenum());
        nitrogenWrapper = new ValueWrapper<>(bean.getNitrogen());
        nickelWrapper = new ValueWrapper<>(bean.getNickel());
        phosphorusWrapper = new ValueWrapper<>(bean.getPhosphorus());
        potassiumWrapper = new ValueWrapper<>(bean.getPotassium());
        seleniumWrapper = new ValueWrapper<>(bean.getSelenium());
        sodiumWrapper = new ValueWrapper<>(bean.getSodium());
        sulphurWrapper = new ValueWrapper<>(bean.getSulphur());
        vanadiumWrapper = new ValueWrapper<>(bean.getVanadium());
        zincWrapper = new ValueWrapper<>(bean.getZinc());        
    }

    @Override
    public abstract GwiseFertiliserBean getBean();

    public abstract FertiliserType getType();

    public ValueWrapper<String> getManufacturerWrapper() {
        return manufacturerWrapper;
    }

    public String getManufacturer() {
        return manufacturerWrapper.getValue();
    }

    public void setManufacturer(String manufacturer) {
        manufacturerWrapper.setValue(manufacturer);
    }

    public ValueWrapper<String> getShopWrapper() {
        return shopWrapper;
    }

    public String getShop() {
        return shopWrapper.getValue();
    }

    public void setShop(String shop) {
        shopWrapper.setValue(shop);
    }

    public ValueWrapper<Double> getPriceWrapper() {
        return priceWrapper;
    }

    public double getPrice() {
        return priceWrapper.getValue();
    }

    public void setPrice(double price) {
        priceWrapper.setValue(price);
    }

    public ObservableListWrapperA<String> getWebLinks() {
        return webLinks;
    }

    public ValueWrapper<Date> getDatePurchasedWrapper() {
        return datePurchasedWrapper;
    }

    public Date getDatePurchased() {
        return datePurchasedWrapper.getValue();
    }

    public void setDatePurchased(Date datePurchased) {
        datePurchasedWrapper.setValue(datePurchased);
    }

    public ValueWrapper<Double> getSuggestedUsageAmountWrapper() {
        return suggestedUsageAmountWrapper;
    }

    public double getSuggestedUsageAmount() {
        return suggestedUsageAmountWrapper.getValue();
    }

    public void setSuggestedUsageAmount(double suggestedUsageAmount) {
        suggestedUsageAmountWrapper.setValue(suggestedUsageAmount);
    }

    public ValueWrapper<String> getUsageUomWrapper() {
        return usageUomWrapper;
    }

    public String getUsageUom() {
        return usageUomWrapper.getValue();
    }

    public void setUsageUom(String usageUom) {
        usageUomWrapper.setValue(usageUom);
    }

    public ValueWrapper<Double> getPhWrapper() {
        return phWrapper;
    }

    public double getPh() {
        return phWrapper.getValue();
    }

    public void setPh(double ph) {
        phWrapper.setValue(ph);
    }

    public ValueWrapper<Double> getAluminiumWrapper() {
        return aluminiumWrapper;
    }

    public double getAluminium() {
        return aluminiumWrapper.getValue();
    }

    public void setAluminium(double aluminium) {
        aluminiumWrapper.setValue(aluminium);
    }

    public ValueWrapper<Double> getBoronWrapper() {
        return boronWrapper;
    }

    public double getBoron() {
        return boronWrapper.getValue();
    }

    public void setBoron(double boron) {
        boronWrapper.setValue(boron);
    }

    public ValueWrapper<Double> getCalciumWrapper() {
        return calciumWrapper;
    }

    public double getCalcium() {
        return calciumWrapper.getValue();
    }

    public void setCalcium(double calcium) {
        calciumWrapper.setValue(calcium);
    }

    public ValueWrapper<Double> getChlorineWrapper() {
        return chlorineWrapper;
    }

    public double getChlorine() {
        return chlorineWrapper.getValue();
    }

    public void setChlorine(double chlorine) {
        chlorineWrapper.setValue(chlorine);
    }

    public ValueWrapper<Double> getCobaltWrapper() {
        return cobaltWrapper;
    }

    public double getCobalt() {
        return cobaltWrapper.getValue();
    }

    public void setCobalt(double cobalt) {
        cobaltWrapper.setValue(cobalt);
    }

    public ValueWrapper<Double> getCopperWrapper() {
        return copperWrapper;
    }

    public double getCopper() {
        return copperWrapper.getValue();
    }

    public void setCopper(double copper) {
        copperWrapper.setValue(copper);
    }

    public ValueWrapper<Double> getIronWrapper() {
        return ironWrapper;
    }

    public double getIron() {
        return ironWrapper.getValue();
    }

    public void setIron(double iron) {
        ironWrapper.setValue(iron);
    }

    public ValueWrapper<Double> getMagnesiumWrapper() {
        return magnesiumWrapper;
    }

    public double getMagnesium() {
        return magnesiumWrapper.getValue();
    }

    public void setMagnesium(double magnesium) {
        magnesiumWrapper.setValue(magnesium);
    }

    public ValueWrapper<Double> getManganeseWrapper() {
        return manganeseWrapper;
    }

    public double getManganese() {
        return manganeseWrapper.getValue();
    }

    public void setManganese(double manganese) {
        manganeseWrapper.setValue(manganese);
    }

    public ValueWrapper<Double> getMolybdenumWrapper() {
        return molybdenumWrapper;
    }

    public double getMolybdenum() {
        return molybdenumWrapper.getValue();
    }

    public void setMolybdenum(double molybdenum) {
        molybdenumWrapper.setValue(molybdenum);
    }

    public ValueWrapper<Double> getNitrogenWrapper() {
        return nitrogenWrapper;
    }

    public double getNitrogen() {
        return nitrogenWrapper.getValue();
    }

    public void setNitrogen(double nitrogen) {
        nitrogenWrapper.setValue(nitrogen);
    }

    public ValueWrapper<Double> getNickelWrapper() {
        return nickelWrapper;
    }

    public double getNickel() {
        return nickelWrapper.getValue();
    }

    public void setNickel(double nickel) {
        nickelWrapper.setValue(nickel);
    }

    public ValueWrapper<Double> getPhosphorusWrapper() {
        return phosphorusWrapper;
    }

    public double getPhosphorus() {
        return phosphorusWrapper.getValue();
    }

    public void setPhosphorus(double phosphorus) {
        phosphorusWrapper.setValue(phosphorus);
    }

    public ValueWrapper<Double> getPotassiumWrapper() {
        return potassiumWrapper;
    }

    public double getPotassium() {
        return potassiumWrapper.getValue();
    }

    public void setPotassium(double potassium) {
        potassiumWrapper.setValue(potassium);
    }

    public ValueWrapper<Double> getSeleniumWrapper() {
        return seleniumWrapper;
    }

    public double getSelenium() {
        return seleniumWrapper.getValue();
    }

    public void setSelenium(double selenium) {
        seleniumWrapper.setValue(selenium);
    }

    public ValueWrapper<Double> getSodiumWrapper() {
        return sodiumWrapper;
    }

    public double getSodium() {
        return sodiumWrapper.getValue();
    }

    public void setSodium(double sodium) {
        sodiumWrapper.setValue(sodium);
    }

    public ValueWrapper<Double> getSulphurWrapper() {
        return sulphurWrapper;
    }

    public double getSulphur() {
        return sulphurWrapper.getValue();
    }

    public void setSulphur(double sulphur) {
        sulphurWrapper.setValue(sulphur);
    }

    public ValueWrapper<Double> getVanadiumWrapper() {
        return vanadiumWrapper;
    }

    public double getVanadium() {
        return vanadiumWrapper.getValue();
    }

    public void setVanadium(double vanadium) {
        vanadiumWrapper.setValue(vanadium);
    }

    public ValueWrapper<Double> getZincWrapper() {
        return zincWrapper;
    }

    public double getZinc() {
        return zincWrapper.getValue();
    }

    public void setZinc(double zinc) {
        zincWrapper.setValue(zinc);
    }

}
