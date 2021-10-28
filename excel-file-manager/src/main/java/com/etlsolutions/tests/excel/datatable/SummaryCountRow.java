package com.etlsolutions.tests.excel.datatable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SummaryCountRow extends IdentifiableRow
{

  private String countryCode;
  private String dealerCode;
  private String manufacturer;
  private int totalCount;
  private int vipCount;
  private int firstNameCount;
  private int lastNameCount;
  private int phoneCount;
  private int workPhoneCount;
  private int mobileCount;
  private int emailCount;
  private int suppressionCount;

  private String totalCountString;
  private String vipCountString;
  private String firstNameCountString;
  private String lastNameCountString;
  private String phoneCountString;
  private String workPhoneCountString;
  private String mobileCountString;
  private String emailCountString;
  private String suppressionCountString;

  private double vipCountPercentage;
  private double firstNameCountPercentage;
  private double lastNameCountPercentage;
  private double phoneCountPercentage;
  private double workPhoneCountPercentage;
  private double mobileCountPercentage;
  private double emailCountPercentage;
  private double suppressionCountPercentage;  
  
  private String vipCountPercentageString;
  private String firstNameCountPercentageString;
  private String lastNameCountPercentageString;
  private String phoneCountPercentageString;
  private String workPhoneCountPercentageString;
  private String mobileCountPercentageString;
  private String emailCountPercentageString;
  private String suppressionCountPercentageString;

  public SummaryCountRow()
  {
  }
  
  @SuppressWarnings("OverridableMethodCallInConstructor")
  public SummaryCountRow(
          
          String id,
          String countryCode,
          String dealerCode,
          String manufacturer,
          int totalCount,
          int vipCount,
          int firstNameCount,
          int lastNameCount,
          int phoneCount,
          int workPhoneCount,
          int mobileCount,
          int emailCount,
          int suppressionCount)
  {
    super(id);
    this.countryCode = countryCode;
    this.dealerCode = dealerCode;
    this.manufacturer = manufacturer;
    this.totalCount = totalCount;
    setTotalCount(totalCount);
    setVipCount(vipCount);
    setFirstNameCount(firstNameCount);
    setLastNameCount(lastNameCount);
    setPhoneCount(phoneCount);
    setWorkPhoneCount(workPhoneCount);
    setMobileCount(mobileCount);
    setEmailCount(emailCount);
    setSuppressionCount(suppressionCount);
  }

  public String getCountryCode()
  {
    return countryCode;
  }

  public String getDealerCode()
  {
    return dealerCode;
  }

  public String getManufacturer()
  {
    return manufacturer;
  }

  public int getTotalCount()
  {

    return totalCount;

  }

  public int getVipCount()
  {
    return vipCount;
  }

  public int getFirstNameCount()
  {
    return firstNameCount;
  }

  public int getLastNameCount()
  {
    return lastNameCount;
  }

  public int getPhoneCount()
  {
    return phoneCount;
  }

  public int getWorkPhoneCount()
  {
    return workPhoneCount;
  }

  public int getMobileCount()
  {
    return mobileCount;
  }

  public int getEmailCount()
  {
    return emailCount;
  }

  public int getSuppressionCount()
  {
    return suppressionCount;
  }

  public String getTotalCountString()
  {
    return totalCountString;
  }

  public String getVipCountString()
  {
    return vipCountString;
  }

  public String getFirstNameCountString()
  {
    return firstNameCountString;
  }

  public String getLastNameCountString()
  {
    return lastNameCountString;
  }

  public String getPhoneCountString()
  {
    return phoneCountString;
  }

  public String getWorkPhoneCountString()
  {
    return workPhoneCountString;
  }

  public String getMobileCountString()
  {
    return mobileCountString;
  }

  public String getEmailCountString()
  {
    return emailCountString;
  }

  public String getSuppressionCountString()
  {
    return suppressionCountString;
  }

  public double getVipCountPercentage()
  {
    return vipCountPercentage;
  }

  public double getFirstNameCountPercentage()
  {
    return firstNameCountPercentage;
  }

  public double getLastNameCountPercentage()
  {
    return lastNameCountPercentage;
  }

  public double getPhoneCountPercentage()
  {
    return phoneCountPercentage;
  }

  public double getWorkPhoneCountPercentage()
  {
    return workPhoneCountPercentage;
  }

  public double getMobileCountPercentage()
  {
    return mobileCountPercentage;
  }

  public double getEmailCountPercentage()
  {
    return emailCountPercentage;
  }

  public double getSuppressionCountPercentage()
  {
    return suppressionCountPercentage;
  }
    
  public String getVipCountPercentageString()
  {
    return vipCountPercentageString;
  }

  public String getFirstNameCountPercentageString()
  {
    return firstNameCountPercentageString;
  }

  public String getLastNameCountPercentageString()
  {
    return lastNameCountPercentageString;
  }

  public String getPhoneCountPercentageString()
  {
    return phoneCountPercentageString;
  }

  public String getWorkPhoneCountPercentageString()
  {
    return workPhoneCountPercentageString;
  }

  public String getMobileCountPercentageString()
  {
    return mobileCountPercentageString;
  }

  public String getEmailCountPercentageString()
  {
    return emailCountPercentageString;
  }

  public String getSuppressionCountPercentageString()
  {
    return suppressionCountPercentageString;
  }  
  
  public void setCountryCode(String countryCode)
  {
    this.countryCode = countryCode;
  }

  public void setDealerCode(String dealerCode)
  {
    this.dealerCode = dealerCode;
  }

  public void setManufacturer(String manufacturer)
  {
    this.manufacturer = manufacturer;
  }

  public void setTotalCount(int totalCount)
  {
    this.totalCount = totalCount;
    totalCountString = getString(totalCount);
  }

  public void setVipCount(int vipCount)
  {
    this.vipCount = vipCount;  
    vipCountString = getString(vipCount);
    vipCountPercentage = getPercentage(vipCount, totalCount);
    vipCountPercentageString = getPercentageString(vipCount, totalCount);
  }

  public void setFirstNameCount(int firstNameCount)
  {
    this.firstNameCount = firstNameCount;
    firstNameCountString = getString(firstNameCount);
    firstNameCountPercentage = getPercentage(firstNameCount, totalCount);
    firstNameCountPercentageString = getPercentageString(firstNameCount, totalCount);
  }

  public void setLastNameCount(int lastNameCount)
  {
    this.lastNameCount = lastNameCount;
    lastNameCountString = getString(lastNameCount);
    lastNameCountPercentage = getPercentage(lastNameCount, totalCount);
    lastNameCountPercentageString = getPercentageString(lastNameCount, totalCount);
  }

  public void setPhoneCount(int phoneCount)
  {
    this.phoneCount = phoneCount;
    phoneCountString = getString(phoneCount);
    phoneCountPercentage = getPercentage(phoneCount, totalCount);
    phoneCountPercentageString = getPercentageString(phoneCount, totalCount);
  }

  public void setWorkPhoneCount(int workPhoneCount)
  {
    this.workPhoneCount = workPhoneCount;
    workPhoneCountString = getString(workPhoneCount);
    workPhoneCountPercentage = getPercentage(workPhoneCount, totalCount);
    workPhoneCountPercentageString = getPercentageString(workPhoneCount, totalCount);
  }

  public void setMobileCount(int mobileCount)
  {
    this.mobileCount = mobileCount;
    mobileCountString = getString(mobileCount);
    mobileCountPercentage = getPercentage(mobileCount, totalCount);
    mobileCountPercentageString = getPercentageString(mobileCount, totalCount);
  }

  public void setEmailCount(int emailCount)
  {
    this.emailCount = emailCount;
    emailCountString = getString(emailCount);
    emailCountPercentage = getPercentage(emailCount, totalCount);
    emailCountPercentageString = getPercentageString(emailCount, totalCount);
  }

  public void setSuppressionCount(int suppressionCount)
  {
    this.suppressionCount = suppressionCount;
    suppressionCountString = getString(suppressionCount);
    suppressionCountPercentage = getPercentage(suppressionCount, totalCount);
    suppressionCountPercentageString = getPercentageString(suppressionCount, totalCount);
  }

  private String getString(int value)
  {
    return String.format("%,d", value);
  }  
  
  private double getPercentage(int value, int totalCount) {
    
//    int v1 = value * 10000 / totalCount;    
  //  return v1 *10000 + getCountryCode().charAt(0);
    
    
    
      double d = value * 100.0 / totalCount;    
    BigDecimal b = new BigDecimal(d);
    return b.setScale(2, RoundingMode.HALF_UP).doubleValue();
  } 
  
  private String getPercentageString(int value, int totalCount)
  { 
  
    double d = value * 100.0 / totalCount;    
    BigDecimal b = new BigDecimal(d);
    return b.setScale(2, RoundingMode.HALF_UP) + "%";
  }
}

