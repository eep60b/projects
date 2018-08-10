package com.etlsolutions.javafx.data.plant;

import java.util.Date;

/**
 *
 * @author zc
 */
public class GrowingTermination {
  
  private int id;
  private String reason; //Harvested. destroied by disease, insecte, cold weather, hot weather, droupht, tater log, high wind, over-fertiliser.
  private Date time;
  private String description; //Manually removed. Natrual life cycle finished. Died due to desearse or insect.
}
