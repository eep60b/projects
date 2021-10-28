package com.etlsolutions.excel.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class NavigationController implements Serializable
{

  private static final long serialVersionUID = 3540538435405384L;

  private static final String JLR_KPI_HOME_URL = "com.etlsolutions.jlr.kpi.homeUrl";

  private int activTab;

  public NavigationController()
  {
    Logger.getLogger(NavigationController.class).info("CONSTRUCTING NAVIGATIONCONTROLLER");
  }

  
  public int getActivTab()
  {
    return activTab;
  }

  public void setActivTab(int activTab)
  {
    this.activTab = activTab;
  }
}
