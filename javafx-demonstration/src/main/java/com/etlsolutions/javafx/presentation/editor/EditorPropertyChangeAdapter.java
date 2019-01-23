package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import static com.etlsolutions.javafx.presentation.editor.EditorController.EDITOR_VALUE_PROPERTY;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zc
 */
public class EditorPropertyChangeAdapter implements PropertyChangeListener {

    private final TextArea informationTextArea;
    private final TilePane imageTilePane;

    public EditorPropertyChangeAdapter(TextArea informationTextArea, TilePane imageTilePane) {
        this.informationTextArea = informationTextArea;
        this.imageTilePane = imageTilePane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<DataUnit> wrapper = (ValueWrapper<DataUnit>)evt.getSource();        
        DataUnit data = wrapper.getValue();        
        data.addListener(DataUnit.DESCRIPTION_PROPERTY, new EditorDescriptionChangeAdapter(data, informationTextArea));
        data.getImageLinks().addListener(new EditorImageLinksAdapter(data, imageTilePane));
    }

}
