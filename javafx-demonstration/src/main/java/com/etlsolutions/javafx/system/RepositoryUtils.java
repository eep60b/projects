package com.etlsolutions.javafx.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author zc
 */
public enum RepositoryUtils {

    ;

    public static void initRepository(String... args) throws IOException {
        
        File repositoryDirectory = new File(SettingConstants.REPOSITORY_LOCATION);

        if (!repositoryDirectory.isDirectory()) {

            boolean success = repositoryDirectory.mkdirs();

            if (!success) {
                throw new IOException("Failed to create directory: " + SettingConstants.REPOSITORY_LOCATION);
            }
        }

        File configFile = new File(SettingConstants.REPOSITORY_CONFIG_FILE_PATH);
        Properties properties = new Properties();
        if (configFile.exists()) {
            try (FileInputStream in = new FileInputStream(configFile)) {
                properties.load(in);
            }
        }

        ProjectManager.getInstance().init(properties);

    }
}
