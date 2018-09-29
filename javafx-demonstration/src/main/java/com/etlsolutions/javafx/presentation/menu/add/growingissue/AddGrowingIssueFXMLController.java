package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import com.etlsolutions.javafx.presentation.FxmlControllable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AddGrowingIssueFXMLController implements FxmlControllable<AddGrowingIssueDataModel>{

    private AddGrowingIssueDataModel model;
    private Stage stage;

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
    public void setModel(AddGrowingIssueDataModel model) {
        this.model = model;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
}
