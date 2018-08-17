package com.etlsolutions.javafx.data;

import static com.etlsolutions.javafx.system.SettingConstants.BUNDLE_PATH;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ResourceBundle;

/**
 *
 * @author zc
 */
public abstract class DataUnitPart {

  @JsonIgnore
  public static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_PATH);      
  
  @JsonIgnore
  private final DataUnitChangeSupport support = new DataUnitChangeSupport();
  
  
  public abstract DataUnitPart createInitialisedInstance();
  
  public boolean addListener(String property, DataUnitChangeListener listener) {
    return support.addListener(property, listener);
  }

  public void fireChange(String property) {
    support.fireChange(property);
  }

  public void fireChange(String property, Object oldVaue, Object newValue) {
    support.fireChange(property, oldVaue, newValue);
  }

  public void fireChange() {
    support.fireChange();
  }
 
  
}