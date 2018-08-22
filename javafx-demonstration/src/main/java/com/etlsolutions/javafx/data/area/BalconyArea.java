package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class BalconyArea extends Area {

  private List<Container> containers; 

  public List<Container> getContainers() {
    return new ArrayList<>(containers);
  }

  public void setContainers(List<Container> containers) {
    this.containers = new ArrayList<>(containers);
  }
}
