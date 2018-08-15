package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImgLink;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class BalconyArea extends Area {

  private List<Container> containers; 
  
  @Override
  public BalconyArea createInitialisedInstance() {
    BalconyArea a = new BalconyArea();
    a.init();
    a.setTitle("Untitled");
    a.setImgLinks(new ArrayList<ImgLink>());
    a.setContainers(new ArrayList<Container>());
    return a;
  }

  public List<Container> getContainers() {
    return new ArrayList<>(containers);
  }

  public void setContainers(List<Container> containers) {
    this.containers = new ArrayList<>(containers);
  }
}
