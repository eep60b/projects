package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.plant.GrowingFertiliser;
import java.util.Date;

/**
 *
 * @author zc
 */
public class FertilisationTask extends Log
{
  private GrowingFertiliser fertiliser;
  private Date time;
  private double amount;
  private String uom;
}
