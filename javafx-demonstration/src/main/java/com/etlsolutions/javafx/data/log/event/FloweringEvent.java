package com.etlsolutions.javafx.data.log.event;

import com.etlsolutions.javafx.data.log.Log;
import java.util.Date;

/**
 *
 * @author zc
 */
public class FloweringEvent extends Log{
  
  private Date start = new Date();
  private Date finish;
  private int numberPerPlant = -1;
  private String color;
}
