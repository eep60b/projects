package com.etlsolutions.javafx.presentation.editor.designtab.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.gwise.system.ProjectManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

/**
 *
 * @author ZhipengChang
 */
public class DesignPanePlantSubgroupDroppedPropertyChangeAdapter implements PropertyChangeListener {

    private final StackPane designPane;

    public DesignPanePlantSubgroupDroppedPropertyChangeAdapter(StackPane designPane) {
        
        this.designPane = designPane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        Plants plants = (Plants) ProjectManager.getInstance().getSelectedDataUnitValueWrapper().getValue();
        
        Location location = (Location) ProjectManager.getInstance().getItem(plants.getLocationId());
        
        ImageView view = getImageView(location.getPoints());
        
        DesignPanePlantsDataModel model  = new DesignPanePlantsDataModel(plants);
        
        view.setUserData(model);
        designPane.getChildren().add(view);
    }
    
    
    public ImageView getImageView(double[] points) {
        
        double maxX = points[0];
        double maxY = points[1];
        double minX = points[0];
        double minY = points[1];
        
        for(int i = 0; i < points.length; i = i + 2) {
            double x = points[i];
            double y = points[i+1];
            
            if(x > maxX) {
                maxX = x;
            }
            
            if(y > maxY) {
                maxY = y;
            }
            
            if(x < minX) {
                minX = x;
            }
            
            if(y < minY) {
                minY = y;
            }
        }
        
        ImageView maskView = new ImageView();    
        maskView.setCursor(Cursor.NONE);
        maskView.setImage(new ImagePattern(new Image("url"), 0, 0, maxX-minX, maxY-minY, true).getImage());
        Polygon p = new Polygon(points);
        maskView.setClip(p);
        return maskView;
    }
}
