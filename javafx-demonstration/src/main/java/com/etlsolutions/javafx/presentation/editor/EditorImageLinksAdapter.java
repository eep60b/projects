package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.gwise.data.ImageLink;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zc
 */
public class EditorImageLinksAdapter implements ListChangeListener<ImageLink> {

    private final DataUnit data;
    private final TilePane imageTilePane;

    public EditorImageLinksAdapter(DataUnit data, TilePane imageTilePane) {

        this.data = data;
        this.imageTilePane = imageTilePane;
    }

    @Override
    public void onChanged(Change<? extends ImageLink> c) {
        for (ImageLink link : c.getAddedSubList()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }
    }
}
