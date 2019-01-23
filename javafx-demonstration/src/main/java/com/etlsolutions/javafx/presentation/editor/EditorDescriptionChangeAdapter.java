package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitChangeListener;
import javafx.scene.control.TextArea;

/**
 *
 * @author zc
 */
public class EditorDescriptionChangeAdapter implements DataUnitChangeListener {

    private final DataUnit data;
    private final TextArea informationTextArea;

    public EditorDescriptionChangeAdapter(DataUnit data, TextArea informationTextArea) {
        
        this.data = data;
        this.informationTextArea = informationTextArea;
    }

    @Override
    public void change() {

        informationTextArea.setText(data.getInformation());
    }
}
