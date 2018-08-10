package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class ContainerSet extends Subarea {
  
  private List<Container> containers = new ArrayList<>();

  public List<Container> getContainers() {
    return new ArrayList<>(containers);
  }

  public void setContainers(List<Container> containers) {
    this.containers = new ArrayList<>(containers);
  }
}
