package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.plant.GrowingMedium;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;

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
    
    public ObservableList<GrowingMedium> loadDefaultGrowingMediums() throws IOException {
        return mapper.readValue(new File(""), ObservableList.class);
    }
}
