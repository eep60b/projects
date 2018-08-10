package com.etlsolutions.javafx.data.plant;

import java.util.List;
import com.etlsolutions.javafx.data.DataUnit;

/**
 * Each object of the Plants class represents a set of plants with an identical variety which are planted in the same time and under the same condition. They should be treated in the same way all the
 * time. If anything is going to be set differently, a new object should be used.
 *
 * @author zc
 */
public class Plants extends DataUnit {

  private PlantVariety variety;
  private PlantsQuantity quantity;
  private GrowingDetail growingDetails;
  private String selectedImgLink;
  private List<String> imgLinks;

}
