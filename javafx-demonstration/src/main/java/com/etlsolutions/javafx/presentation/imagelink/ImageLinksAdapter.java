package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author zc
 */
public class ImageLinksAdapter implements PropertyChangeListener {

    private final HBox imagesHbox;

    public ImageLinksAdapter(HBox imagesHbox) {
        this.imagesHbox = imagesHbox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        DataUnitDataModel model = (DataUnitDataModel) evt.getSource();
        ObservableList<Node> chidren = imagesHbox.getChildren();
        chidren.clear();
        for(ImageLink link : model.getImageLinks()) {   
            LocallyLinkedImage image = new LocallyLinkedImage(link);
            ImageView view = new ImageView(image);
            view.addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageViewMouseClickEventHandler(model));
            Tooltip.install(view, new Tooltip(link.getInformation()));
            chidren.add(view);
        }
    }
}
