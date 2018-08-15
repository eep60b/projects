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
  private List<TransplantTask> transplants = new ArrayList<>();
  private List<PlantThinningTasks> plantThinnings = new ArrayList<>();
  private List<WateringTask> waterings = new ArrayList<>();
  private List<FertilisationTask> fertilisationTasks;
  private List<FloweringEvent> flowerings = new ArrayList<>();
  private List<FruitingEvent> fruitings = new ArrayList<>();
  private List<HarvestingTask> harvests = new ArrayList<>();  
  private List<GrowingIssue> growingIssues = new ArrayList<>();  
  private List<GrowingObservation> growingObervations = new ArrayList<>();
  
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
