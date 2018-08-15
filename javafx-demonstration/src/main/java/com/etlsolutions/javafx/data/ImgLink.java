package com.etlsolutions.javafx.data;

/**
 *
 * @author zc
 */
public class ImgLink extends DataUnitPart {
  
  private int id;
  private boolean isIdSet;  
  private String link;
  private String information;

  public ImgLink() {
  }

  @Override
  public ImgLink createInitialisedInstance() {
    ImgLink imgLink = new ImgLink();
    imgLink.setId(DataUnitIdRegistry.createNewId());
    imgLink.setInformation("Not specified.");    
    return imgLink;
  }
  
  /**
   * Get the ID for this data unit.
   *
   * @return the ID number.
   * @throws IllegalStateException if the ID has not been set.
   */
  public final int getId() {

    if (!isIdSet) {
      throw new IllegalStateException("The ID has not been set.");
    }

    return id;
  }

  /**
   * Set the ID for this data unit. The ID can ONLY be set once. This method can ONLY be called once.
   *
   * @param id - The ID number.
   * @throws IllegalStateException if this method is called second time.
   */
  public final void setId(int id) {
    if (!isIdSet) {
      this.id = id;
      isIdSet = true;
      return;
    }
    throw new IllegalStateException("The ID has already been set.");
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
