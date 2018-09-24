package com.etlsolutions.javafx.data;

import static com.etlsolutions.javafx.system.SettingConstants.*;
import java.util.TreeSet;

/**
 *
 * @author zc
 */
public class DataUnitIdRegistry {

  private static final TreeSet<Integer> IDS = new TreeSet<>();
  
  private DataUnitIdRegistry() {
      
      registerId(DEFAULT_LOCATION_ID);
      registerId(DATA_UNIT_ID_BASE);
  }
  
  public static void registerId(int id) {
    IDS.add(id);
  }
  
  public static int createNewId() {
    
    int newId = IDS.last() + 1;
    IDS.add(newId);
    return newId;
  }
}
