package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
public class GrowingDetail {

  private String description;
  private boolean isAlive = true;
  private GrowingStartPoint startPoint;  
  private GrowingTermination growingTermination;
  private GrowingMedium growingMedium;  
  private List<Transplant> transplants = new ArrayList<>();
  private List<PlantThinning> plantThinnings = new ArrayList<>();
  private List<Watering> waterings = new ArrayList<>();
  private List<FertiliserUsage> fertiliserUsage;
  private List<FlowerSet> flowerings = new ArrayList<>();
  private List<FruitSet> fruitings = new ArrayList<>();
  private List<HarvestSet> harvests = new ArrayList<>();  
  private List<GrowingIssue> growingIssues = new ArrayList<>();  
  private List<GrowingObservation> growingObervations = new ArrayList<>();
}
