package com.etlsolutions.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class FXMLController implements Initializable
{

  @FXML
  private TreeView<String> lifePlantsTreeView;
  @FXML
  private TreeView<String> achievedPlantsTreeView;
  @FXML
  private TreeView<String> locationsTreeView;
  @FXML
  private TreeView<String> logsTreeView;

  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
    loadTreeItems("initial 1", "initial 2", "initial 3");
  }

  // loads some strings into the tree in the application UI.
  public void loadTreeItems(String... rootItems)
  {

    lifePlantsTreeView = new TreeView<>();
    TreeItem<String> root = new TreeItem<>("All plants");
    root.setExpanded(true);
    for (String itemString : rootItems)
    {
      root.getChildren().add(new TreeItem<>(itemString));
    }

    lifePlantsTreeView.setRoot(root);
  }
}
