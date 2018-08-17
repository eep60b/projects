package com.etlsolutions.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class LivePlantsController implements Initializable {

    @FXML
    private TreeView<String> livePlantsTreeView;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTreeItems("initial 1", "initial 2", "initial 3");
    }

    // loads some strings into the tree in the application UI.
    public void loadTreeItems(String... rootItems) {

        //DO NUT do this here: livePlantsTreeView = new TreeView<>();
        TreeItem<String> root = new TreeItem<>("All plants");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }

        livePlantsTreeView.setRoot(root);
        livePlantsTreeView.setShowRoot(false);
    }
}
