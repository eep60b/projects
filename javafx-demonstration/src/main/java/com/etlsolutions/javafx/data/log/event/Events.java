package com.etlsolutions.javafx.data.log.event;

import com.etlsolutions.javafx.data.log.LogGroup;
import java.util.ResourceBundle;

/**
 *
 * @author Zhipeng
 */
public class Events extends LogGroup {

  public Events() {
    super.setTitle(ResourceBundle.getBundle("bundle/allBundles").getString("com.etlsolutions.javafx.data.log.event.Events.Title"));
  }
}
