package com.etlsolutions.gwise.presentation.editor;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.PropertyChangeAdapter;
import java.beans.PropertyChangeEvent;
import javafx.scene.control.TextArea;

/**
 *
 * @author zc
 */
public class GwiseEditorDescriptionChangeAdapter extends PropertyChangeAdapter<GwiseDataUnit> {

    private final TextArea informationTextArea;

    public GwiseEditorDescriptionChangeAdapter(GwiseDataUnit unit, TextArea informationTextArea) {
        
        super(unit);
        this.informationTextArea = informationTextArea;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        informationTextArea.setText(source.getInformation());
    }
}
