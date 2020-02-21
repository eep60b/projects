package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
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
    private String[] webLinks = {};
    private final ValueWrapper<Date> datePurchasedWrapper;
    private final ValueWrapper<Double> suggestedUsageAmountWrapper;
    private String usageUom;
    private double ph = 7.0;
    private double aluminium;
    private double boron;
    private double calcium;
    private double chlorine;
    private double cobalt;
    private double copper;
    private double iron;
    private double magnesium;
    private double manganese;
    private double molybdenum;
    private double nitrogen;
    private double nickel;
    private double phosphorus;
    private double potassium;
    private double selenium;
    private double sodium;
    private double sulphur;
    private double vanadium;
    private double zinc;

    public GwiseFertiliser(String manufaucturer, String shop, double price, Date datePurchased, double suggestedUsageAmount, String usageUom, double aluminium, double boron, double calcium, double chlorine, double cobalt, double copper, double iron, double magnesium, double manganese, double molybdenum, double nitrogen, double nickel, double phosphorus, double potassium, double selenium, double sodium, double sulphur, double vanadium, double zinc, int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        manufacturerWrapper = new ValueWrapper<>(manufaucturer);
        shopWrapper = new ValueWrapper<>(shop);
        priceWrapper = new ValueWrapper<>(price);
        datePurchasedWrapper = new ValueWrapper<>(datePurchased);
        suggestedUsageAmountWrapper = new ValueWrapper<>(suggestedUsageAmount);
        this.usageUom = usageUom;
        this.aluminium = aluminium;
        this.boron = boron;
        this.calcium = calcium;
        this.chlorine = chlorine;
        this.cobalt = cobalt;
        this.copper = copper;
        this.iron = iron;
        this.magnesium = magnesium;
        this.manganese = manganese;
        this.molybdenum = molybdenum;
        this.nitrogen = nitrogen;
        this.nickel = nickel;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.selenium = selenium;
        this.sodium = sodium;
        this.sulphur = sulphur;
        this.vanadium = vanadium;
        this.zinc = zinc;
    }

    public GwiseFertiliser(GwiseFertiliserBean bean) {
        super(bean);
        manufacturerWrapper = new ValueWrapper<>(bean.getManufacturer());
        shopWrapper = new ValueWrapper<>(bean.getShop());
        priceWrapper = new ValueWrapper<>(bean.getPrice());   
        datePurchasedWrapper = new ValueWrapper<>(bean.getDatePurchased());        
        suggestedUsageAmountWrapper = new ValueWrapper<>(bean.getSuggestedUsageAmount());        
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

    public String[] getWebLinks() {
        return webLinks;
    }

    public void setWebLinks(String[] webLinks) {
        this.webLinks = webLinks;
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

    public String getUsageUom() {
        return usageUom;
    }

    public void setUsageUom(String usageUom) {
        this.usageUom = usageUom;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAluminium() {
        return aluminium;
    }

    public void setAluminium(double aluminium) {
        this.aluminium = aluminium;
    }

    public double getBoron() {
        return boron;
    }

    public void setBoron(double boron) {
        this.boron = boron;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getChlorine() {
        return chlorine;
    }

    public void setChlorine(double chlorine) {
        this.chlorine = chlorine;
    }

    public double getCobalt() {
        return cobalt;
    }

    public void setCobalt(double cobalt) {
        this.cobalt = cobalt;
    }

    public double getCopper() {
        return copper;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public double getManganese() {
        return manganese;
    }

    public void setManganese(double manganese) {
        this.manganese = manganese;
    }

    public double getMolybdenum() {
        return molybdenum;
    }

    public void setMolybdenum(double molybdenum) {
        this.molybdenum = molybdenum;
    }

    public double getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(double nitrogen) {
        this.nitrogen = nitrogen;
    }

    public double getNickel() {
        return nickel;
    }

    public void setNickel(double nickel) {
        this.nickel = nickel;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getSelenium() {
        return selenium;
    }

    public void setSelenium(double selenium) {
        this.selenium = selenium;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getSulphur() {
        return sulphur;
    }

    public void setSulphur(double sulphur) {
        this.sulphur = sulphur;
    }

    public double getVanadium() {
        return vanadium;
    }

    public void setVanadium(double vanadium) {
        this.vanadium = vanadium;
    }

    public double getZinc() {
        return zinc;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }

}
