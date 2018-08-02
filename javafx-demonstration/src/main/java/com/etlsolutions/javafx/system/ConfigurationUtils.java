package com.etlsolutions.javafx.system;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author zc
 */
public final class ConfigurationUtils {

  private ConfigurationUtils() {
  }

  public static void initRepository(String... args) throws IOException {
    File repositoryDirectory = new File(SettingConstants.REPOSITORY_LOCATION);

    if (!repositoryDirectory.isDirectory()) {

      boolean success = repositoryDirectory.mkdirs();

      if (!success) {
        throw new IOException("Failed to create directory: " + SettingConstants.REPOSITORY_LOCATION);
      }
    }
  }
}
