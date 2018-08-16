package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImgLink;
import com.etlsolutions.javafx.data.area.subarea.Subarea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class CustomArea extends Area {

  private List<Subarea> subareas;

  public List<Subarea> getSubareas() {
    return new ArrayList<>(subareas);
  }

  public void setSubareas(List<Subarea> subareas) {
    this.subareas = new ArrayList<>(subareas);
  }
}
