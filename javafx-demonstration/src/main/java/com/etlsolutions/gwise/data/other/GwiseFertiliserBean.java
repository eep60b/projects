package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.javafx.data.other.SolidFertiliser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(name = "LiquidFertiliser", value = LiquidFertiliser.class),
    @JsonSubTypes.Type(name = "SolidFertiliser", value = SolidFertiliser.class)
})
public abstract class GwiseFertiliserBean extends GwiseDataUnitBean {

  private String manufacturer = "Not specified";
  private String shop = "Not specified";
  private List<String> webLinks;
  private double price;
  private Date datePurchased;
  private double suggestedUsageAmount;
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

    public GwiseFertiliserBean() {
    }

    public GwiseFertiliserBean(GwiseFertiliser unit) {
        super(unit);
        manufacturer = unit.getManufacturer();
        shop = unit.getShop();
        webLinks = new ArrayList<>(unit.getWebLinks());
        price = unit.getPrice();
        datePurchased = unit.getDatePurchased();
        suggestedUsageAmount = unit.getSuggestedUsageAmount();
        usageUom = unit.getUsageUom();
        ph = unit.getPh();
        aluminium = unit.getAluminium();
        boron = unit.getBoron();
        calcium = unit.getCalcium();
        chlorine = unit.getChlorine();
        cobalt = unit.getCobalt();
        copper = unit.getCopper();
        iron = unit.getIron();
        magnesium = unit.getMagnesium();
        manganese = unit.getManganese();
        molybdenum = unit.getMolybdenum();
        nitrogen = unit.getNitrogen();
        nickel = unit.getNickel();
        phosphorus = unit.getPhosphorus();
        potassium = unit.getPotassium();
        selenium = unit.getSelenium();
        sodium = unit.getSodium();
        sulphur = unit.getSulphur();
        vanadium = unit.getVanadium();
        zinc = unit.getZinc();
    }

  @JsonIgnore
  public abstract FertiliserType getType();
  
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getShop() {
    return shop;
  }

  public void setShop(String shop) {
    this.shop = shop;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<String> getWebLinks() {
    return webLinks;
  }

  public void setWebLinks(List<String> webLinks) {
    this.webLinks = webLinks;
  }

  public Date getDatePurchased() {
    return datePurchased;
  }

  public void setDatePurchased(Date datePurchased) {
    this.datePurchased = datePurchased;
  }

  public double getSuggestedUsageAmount() {
    return suggestedUsageAmount;
  }

  public void setSuggestedUsageAmount(double suggestedUsageAmount) {
    this.suggestedUsageAmount = suggestedUsageAmount;
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
