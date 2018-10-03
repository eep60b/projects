package com.etlsolutions.javafx.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author zc
 */
public class RepositoryManager {

    private static final RepositoryManager INSTANCE = new RepositoryManager();
    
    private final ObjectMapper mapper = new ObjectMapper();

    private RepositoryManager() {
    }
    
    public static RepositoryManager getInstance() {
        return INSTANCE;
    }
    
    public <T> T loadDefaultData(String path, Class<T> c) throws IOException {
        return mapper.readValue(new File(path), c);
    }
}
