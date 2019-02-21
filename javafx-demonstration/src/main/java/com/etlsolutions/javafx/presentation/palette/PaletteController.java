package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.editor.DesignTabStatusManager;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 * The PaletteController class controls the palette scene.
 *
 * @author zc
 */
public class PaletteController extends AbstractFXMLController {

    @FXML
    private AnchorPane paletteAnchorPane;

    @FXML
    private TilePane plantsTilePane;

    @Override
    public void initializeComponents() {

        ValueWrapper<Tab> wrapper = DesignTabStatusManager.getInstance().getWrapper();
        paletteAnchorPane.setVisible(wrapper.getValue() != null);
        wrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PalettePropertyChangeAdapter(paletteAnchorPane));

        ValueWrapper<ProjectContents> cwrapper = ProjectManager.getInstance().getContentsValueWrapper();
        ProjectContents cvalue = cwrapper.getValue();
        ProjectContentsPalettePropertyChangeAdaper adapter = new ProjectContentsPalettePropertyChangeAdaper(plantsTilePane);
        adapter.process(cvalue);        
        cwrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, adapter);
    }
}
