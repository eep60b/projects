package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.Date;

/**
 *
 * @author zc
 */
public abstract class Fertiliser extends DataUnit {

  private String manufacturer = "Not specified";
  private String shop = "Not specified";
  private double price;
  private String[] webLinks = {};
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

  public abstract FertiliserType type();
  
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

  public String[] getWebLinks() {
    return webLinks;
  }

  public void setWebLinks(String[] webLinks) {
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
