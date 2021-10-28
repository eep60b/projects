package com.etlsolutions.excel.controller;

import com.etlsolutions.tests.excel.datatable.LazyDqDataModel;
import com.etlsolutions.tests.excel.datatable.SummaryCountRow;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;

@ManagedBean
@ViewScoped
public class SummaryCountController extends AbstractController<SummaryCountRow>
{

  private static final long serialVersionUID = 676202916465527901L;


  private final LazyDqDataModel<SummaryCountRow> dataModel = new LazyDqDataModel<SummaryCountRow>();

  
  

  public SummaryCountController()
  {
    Logger.getLogger(SummaryCountController.class).info("CONSTRUCTING SummaryCountController");
  }

  @PostConstruct
  public void init()
  {
  }

  @Override
  public LazyDqDataModel<SummaryCountRow> getDataModel()
  {
    return dataModel;
  }

}
