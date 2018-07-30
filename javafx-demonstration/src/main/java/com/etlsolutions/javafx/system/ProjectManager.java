/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.system;

import java.io.IOException;

/**
 *
 * @author zc
 */
public class ProjectManager {

  public ProjectConfiguration loadProject() throws IOException {
    return new ProjectConfiguration();
  }

  public ProjectConfiguration createProject() throws IOException {
    return new ProjectConfiguration();
  }

  public void deleteProject(ProjectConfiguration configuration) {

  }
}
