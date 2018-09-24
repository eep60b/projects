package com.etlsolutions.javafx.presentation;

/**
 * basic wizard page class
 *
 * @author zc
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public abstract class WizardPage extends VBox {

    private final WizardPageDataModel model;
    private final Button previousPageButton;
    private final Button nextPageButton;
    Button cancelButton = new Button("Cancel");
    Button finishButton = new Button("_Finish");

    public WizardPage(WizardPageDataModel model) {
        this.model = model;
        setId(model.getTitle());        
        previousPageButton = new Button("Previous Page");
        setSpacing(10);
        Region spring = new Region();
        VBox.setVgrow(spring, Priority.ALWAYS);
        getChildren().addAll(getContent(), spring, getButtons());

        previousPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                priorPage();
            }
        });
        
        nextPageButton = new Button("Next Page");
        nextPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nextPage();
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getWizard().cancel();
            }
        });
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getWizard().finish();
            }
        });
    }

    HBox getButtons() {
        Region spring = new Region();
        HBox.setHgrow(spring, Priority.ALWAYS);
        HBox buttonBar = new HBox(5);
        cancelButton.setCancelButton(true);
        finishButton.setDefaultButton(true);
        buttonBar.getChildren().addAll(spring, previousPageButton, nextPageButton, cancelButton, finishButton);
        return buttonBar;
    }

    public abstract Parent getContent();

    boolean hasNextPage() {
        return getWizard().hasNextPage();
    }

    boolean hasPriorPage() {
        return getWizard().hasPriorPage();
    }

    void nextPage() {
        getWizard().nextPage();
    }

    void priorPage() {
        getWizard().priorPage();
    }


    Wizard getWizard() {
        return (Wizard) getParent();
    }

    public void manageButtons() {
        if (!hasPriorPage()) {
            previousPageButton.setDisable(true);
        }

        if (!hasNextPage()) {
            nextPageButton.setDisable(true);
        }
    }
}
