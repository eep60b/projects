package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 */
public class LogItem implements Item {
  
  private final LogGroupItem parent;

  public LogItem(LogGroupItem parent) {
    this.parent = parent;
  }
}
