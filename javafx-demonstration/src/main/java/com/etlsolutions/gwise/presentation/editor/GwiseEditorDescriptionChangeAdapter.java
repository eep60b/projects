package com.etlsolutions.gwise.presentation.editor;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.GwiseDataUnitPropertyChangeAdapter;
import java.beans.PropertyChangeEvent;
import javafx.scene.control.TextArea;

/**
 *
 * @author zc
 */
public class GwiseEditorDescriptionChangeAdapter extends GwiseDataUnitPropertyChangeAdapter {

    private final TextArea informationTextArea;

    public GwiseEditorDescriptionChangeAdapter(GwiseDataUnit unit, TextArea informationTextArea) {
        
        super(unit);
        this.informationTextArea = informationTextArea;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        informationTextArea.setText(unit.getInformation());
    }
}
