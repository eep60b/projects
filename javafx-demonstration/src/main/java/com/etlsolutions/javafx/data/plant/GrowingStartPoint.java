package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitPart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 *
 * @author zc
 */
public class GrowingStartPoint extends DataUnitPart {

  public static enum Source {
    SEED, CUTTING, YOUNG_PLANT, GROUND_LAYERING, DIVISION, GRAFTING, RUNNING, BULB, CORM, TUBER, RHIZOMES, TWN_SCALING, OTHER
  }

  @JsonIgnore    
  public static final String SOURCE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingStartPoint.SOURCE_PROPERTY";
  @JsonIgnore  
  public static final String TIME_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingStartPoint.TIME_PROPERTY";
  
  private Source source;
  private Date time;

  public Source getSource() {
    return source;
  }

  public void setSource(Source source) {
    Source oldValue = this.source;
    this.source = source;
    fireChange(SOURCE_PROPERTY, oldValue, this.source);
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
