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
