package com.etlsolutions.javafx.data;

import static com.etlsolutions.javafx.system.SettingConstants.*;
import java.util.TreeSet;

/**
 *
 * @author zc
 */
public final class DataUnitIdRegistry {

  private static final DataUnitIdRegistry INSTANCE = new DataUnitIdRegistry();
  
  private final TreeSet<Integer> idSet = new TreeSet<>();
  
  private DataUnitIdRegistry() {
      
      registerId(DEFAULT_LOCATION_ID);
      registerId(DATA_UNIT_ID_BASE);
  }
  
  public static final DataUnitIdRegistry getInstance() {
      return INSTANCE;
  }
  
  public void registerId(int id) {
    idSet.add(id);
  }
  
  public int createNewId() {
    
    int newId = idSet.last() + 1;
    idSet.add(newId);
    return newId;
  }
}
