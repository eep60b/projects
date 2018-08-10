package com.etlsolutions.javafx.system;

import java.io.File;

/**
 * The ProjectConfiguration class contains all the information about a project to run the application.
 *
 * @author zc
 */
public class ProjectConfiguration
{
  private String name;
  private String parentPath;
  private boolean encrypted;
  private int nextItemId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParentPath() {
    return parentPath;
  }

  public void setParentPath(String parentPath) {
    this.parentPath = parentPath;
  }

  public boolean isPasswordProtected() {
    return encrypted;
  }

  public void setPasswordProtected(boolean passwordProtected) {
    this.encrypted = passwordProtected;
  }
  
  public String getProjectPath() {
    return parentPath + File.separator + name;
  }
  
  public String getJsonDataPath() {
    return getProjectPath() + File.separator + "data" + File.separator + "json";
  }

  public boolean isEncrypted() {
    return encrypted;
  }

  public void setEncrypted(boolean encrypted) {
    this.encrypted = encrypted;
  }

  public int getNextItemId() {
    return nextItemId;
  }

  public void setNextItemId(int nextItemId) {
    this.nextItemId = nextItemId;
  }  
}
