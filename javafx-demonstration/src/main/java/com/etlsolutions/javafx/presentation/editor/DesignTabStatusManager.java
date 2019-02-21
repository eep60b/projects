package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.ValueWrapper;
import javafx.scene.control.Tab;

/**
 * The DesignTabStatusManager class save the status of the editor design tab.
 * The wrapper will keep the tab when selected. This allows the palette to be notified.
 *
 * @author zc
 */
public class DesignTabStatusManager {

    private static final DesignTabStatusManager INSTANCE = new DesignTabStatusManager();

    private final ValueWrapper<Tab> wrapper = new ValueWrapper<>(null);

    private DesignTabStatusManager() {
    }

    public static DesignTabStatusManager getInstance() {
        return INSTANCE;
    }

    public ValueWrapper<Tab> getWrapper() {
        return wrapper;
    }
}
