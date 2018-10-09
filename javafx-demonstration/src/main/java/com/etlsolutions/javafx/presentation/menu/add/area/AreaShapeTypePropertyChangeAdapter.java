package com.etlsolutions.javafx.presentation.menu.add.area;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author zc
 */
public class AreaShapeTypePropertyChangeAdapter implements PropertyChangeListener {

    private final HBox areaShapeContentHbox;
    private final Label lengthLabel;
    private final TextField lengthTextField;
    private final Label widthLabel;
    private final TextField widthTextField;
    private final Label sideLabel;
    private final TextField sideTextField;
    private final Label diameterLabel;
    private final TextField diameterTextField;
    private final Label aLebel;
    private final TextField aTextField;
    private final Label bLebel;
    private final TextField bTextField;
    private final Label cLebel;
    private final TextField cTextField;
    private final Label areaLabel;
    private final TextField areaTextField;

    public AreaShapeTypePropertyChangeAdapter(HBox areaShapeContentHbox, Label lengthLabel, TextField lengthTextField, Label widthLabel, TextField widthTextField, Label sideLabel, TextField sideTextField, Label diameterLabel, TextField diameterTextField, Label aLebel, TextField aTextField, Label bLebel, TextField bTextField, Label cLebel, TextField cTextField, Label areaLabel, TextField areaTextField) {
        this.areaShapeContentHbox = areaShapeContentHbox;
        this.lengthLabel = lengthLabel;
        this.lengthTextField = lengthTextField;
        this.widthLabel = widthLabel;
        this.widthTextField = widthTextField;
        this.sideLabel = sideLabel;
        this.sideTextField = sideTextField;
        this.diameterLabel = diameterLabel;
        this.diameterTextField = diameterTextField;
        this.aLebel = aLebel;
        this.aTextField = aTextField;
        this.bLebel = bLebel;
        this.bTextField = bTextField;
        this.cLebel = cLebel;
        this.cTextField = cTextField;
        this.areaLabel = areaLabel;
        this.areaTextField = areaTextField;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddAreaDialogDataModel model = (AddAreaDialogDataModel) evt.getSource();

        ObservableList<Node> children = areaShapeContentHbox.getChildren();
        children.clear();
        switch (model.getSelectedAreaShapeType()) {
            case RECTANGLE:
                children.addAll(areaLabel, areaTextField, lengthLabel, lengthTextField, widthLabel, widthTextField);
                areaTextField.setDisable(true);
                break;
            case SQURE:
                children.addAll(areaLabel, areaTextField, sideLabel, sideTextField);
                areaTextField.setDisable(true);
                break;
            case CIRCLE:
                children.addAll(areaLabel, areaTextField, diameterLabel, diameterTextField);
                areaTextField.setDisable(true);
                break;
            case TRIANGLE:
                children.addAll(areaLabel, areaTextField, aLebel, aTextField, bLebel, bTextField, cLebel, cTextField);
                areaTextField.setDisable(true);
                break;
            case IRREGULAR:
                children.addAll(areaLabel, areaTextField);
                areaTextField.setDisable(false);
        }
    }
}
