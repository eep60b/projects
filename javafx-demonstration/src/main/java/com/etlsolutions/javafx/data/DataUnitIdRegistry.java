package com.etlsolutions.javafx.data;

import java.util.TreeSet;

/**
 *
 * @author zc
 */
public class DataUnitIdRegistry {

  private static final TreeSet<Integer> IDS = new TreeSet<>();
  
  public DataUnitIdRegistry() {
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
