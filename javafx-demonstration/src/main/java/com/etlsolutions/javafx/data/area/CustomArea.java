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

  @Override
  public DataUnit createInitialisedInstance() {
    CustomArea a = new CustomArea();
    a.init();
    a.setTitle("Untitled");
    a.setImgLinks(new ArrayList<ImgLink>());
    a.setSubareas(new ArrayList<Subarea>());
    return a;
  }

  public List<Subarea> getSubareas() {
    return new ArrayList<>(subareas);
  }

  public void setSubareas(List<Subarea> subareas) {
    this.subareas = new ArrayList<>(subareas);
  }
}
