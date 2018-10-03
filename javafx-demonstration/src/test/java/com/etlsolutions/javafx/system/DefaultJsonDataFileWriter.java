package com.etlsolutions.javafx.system;

import static com.etlsolutions.javafx.system.SettingConstants.DEFAULT_DATA_DIRECTORY;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author zc
 */
public class DefaultJsonDataFileWriter {

    private final ObjectMapper mapper = new ObjectMapper();

    public void write(Object[] objects) throws IOException {

        for (Object object : objects) {
            mapper.writeValue(new File(DEFAULT_DATA_DIRECTORY + File.separator + object.getClass().getSimpleName() + SettingConstants.JSON_FILE_EXTENSION), object);
        }
    }
}