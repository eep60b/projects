package com.etlsolutions.gwise.presentation.editor;

import com.etlsolutions.gwise.data.GwiseDataUnitListChangeAdapter;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zc
 */
public class GwiseEditorImageLinksAdapter extends GwiseDataUnitListChangeAdapter<ImageLink> {

    private final TilePane imageTilePane;

    public GwiseEditorImageLinksAdapter(List<ImageLink> list, TilePane imageTilePane) {

        super(list);
        this.imageTilePane = imageTilePane;
    }

    @Override
    public void onChanged(Change<? extends ImageLink> c) {
        for (ImageLink link : c.getAddedSubList()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }
    }
}
