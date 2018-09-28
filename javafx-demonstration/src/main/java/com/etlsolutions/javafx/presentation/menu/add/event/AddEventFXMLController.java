package com.etlsolutions.javafx.presentation.menu.add.event;

import com.etlsolutions.javafx.presentation.ChildController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddEventFXMLController implements ChildController<AddEventDataModel> {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setParentModel(AddEventDataModel parentModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setParentStage(Stage parentStage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
