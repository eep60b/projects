package com.etlsolutions.excel.cache;

import java.util.Comparator;

public abstract class CommonComparator<T> implements Comparator<T>
{
  
  public final int compare(Comparable c1, Comparable c2) {
    
    if(c1 == null) {
      return c2 == null ? 0 : 1;
    }
    
    return c1.compareTo(c2);
  }
}
