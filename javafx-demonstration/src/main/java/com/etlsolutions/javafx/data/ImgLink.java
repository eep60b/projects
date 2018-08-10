package com.etlsolutions.javafx.data;

/**
 *
 * @author zc
 */
public class ImgLink {
  
  private int id;
  private String link;
  private String information;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + this.id;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ImgLink other = (ImgLink) obj;
    return this.id == other.id;
  }
}
