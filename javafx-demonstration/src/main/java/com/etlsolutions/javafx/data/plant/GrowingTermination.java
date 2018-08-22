package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitPart;
import java.util.Date;

/**
 *
 * @author zc
 */
public class GrowingTermination extends DataUnitPart {
  
  public static final String REASON_PROPERTY = "com.etlsolutions.javafx.data.DataUnitPart.GrowingTermination.REASON_PROPERTY";
  public static final String TIME_PROPERTY = "com.etlsolutions.javafx.data.DataUnitPart.GrowingTermination.TIME_PROPERTY";
  
  private String reason; //Harvested. destroied by disease, insecte, cold weather, hot weather, droupht, tater log, high wind, over-fertiliser.
  private Date time;


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    String oldValue = this.reason;
    this.reason = reason;
    fireChange(REASON_PROPERTY, oldValue, this.reason);
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    Date oldValue = this.time;
    this.time = time;
    fireChange(TIME_PROPERTY, oldValue, this.time);
  }
}
