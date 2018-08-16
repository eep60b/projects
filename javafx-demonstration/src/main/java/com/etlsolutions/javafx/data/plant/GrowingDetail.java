package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitPart;
import com.etlsolutions.javafx.data.log.task.PlantThinningTasks;
import com.etlsolutions.javafx.data.log.task.TransplantTask;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.FertilisationTask;
import com.etlsolutions.javafx.data.log.event.FruitingEvent;
import com.etlsolutions.javafx.data.log.event.FloweringEvent;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
public class GrowingDetail extends DataUnitPart {

  private boolean isAlive = true;
  private GrowingStartPoint startPoint;  
  private GrowingTermination growingTermination;
  private GrowingMedium growingMedium;  
  private List<TransplantTask> transplants;
  private List<PlantThinningTasks> plantThinnings;
  private List<WateringTask> waterings;
  private List<FertilisationTask> fertilisationTasks;
  private List<FloweringEvent> flowerings;
  private List<FruitingEvent> fruitings;
  private List<HarvestingTask> harvests;  
  private List<GrowingIssue> growingIssues;  
  private List<GrowingObservation> growingObervations;
  
  @Override
  public GrowingDetail createInitialisedInstance() {
    GrowingDetail d = new GrowingDetail();
    isAlive = true;
    startPoint = new GrowingStartPoint();
    startPoint.createInitialisedInstance();
    growingTermination = new GrowingTermination();
    growingTermination.createInitialisedInstance();
    return d;
  }
}
