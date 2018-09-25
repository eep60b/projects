package com.etlsolutions.javafx.presentation.wizard;

import static com.etlsolutions.javafx.presentation.wizard.WizardDataModel.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class Wizard<T extends WizardDataModel> extends VBox {

    private final Stage stage;
    protected final T model;
    private final Pane contentPane;

    public Wizard(Stage stage, T model) {
        this.stage = stage;
        this.model = model;
        contentPane = new Pane();
    }

    protected abstract Node getCurrentPage();
    
    protected final void init() {
        setSpacing(10);
        Region spring = new Region();
        setVgrow(spring, Priority.ALWAYS);
        Button previousPageButton = new Button("Previous Page");
        previousPageButton.setDisable(model.notToPrevious());        
        previousPageButton.setOnAction(new NavigateToPreviousEventHandler());
        Button nextPageButton = new Button("Next Page");
        nextPageButton.setOnAction(new NavigateToNextEventHandler());
        nextPageButton.setDisable(model.notToNext());
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(new WizardCancelEventHandler());
        Button finishButton = new Button("Finish");
        finishButton.setOnAction(new WizardFinishEventHandler());
        finishButton.setDisable(model.canNotFinish());
        
        contentPane.getChildren().add(getCurrentPage());
        Label errorMessageLabel = new Label();
        errorMessageLabel.setTextFill(Color.RED);
        errorMessageLabel.setText(model.getErrorMessage());
        HBox buttonBar = new HBox(5);
        buttonBar.setAlignment(Pos.CENTER_RIGHT);
        cancelButton.setCancelButton(true);
        finishButton.setDefaultButton(true);
        buttonBar.getChildren().addAll(previousPageButton, nextPageButton, cancelButton, finishButton);
        getChildren().addAll(contentPane, spring, errorMessageLabel, buttonBar);
        model.addPropertyChangeListener(STATUS_PROPERTY, new StatusPropertyChangeAdapter(previousPageButton, nextPageButton, finishButton, errorMessageLabel));        
    }


    public void nextPage() {
        navigateTo(model.getCurrentIndex() + 1);
    }

    public void previousPage() {
        navigateTo(model.getCurrentIndex() - 1);

    }

    private void navigateTo(int newPageIndex) {
        
        model.setCurrentIndex(newPageIndex);
        contentPane.getChildren().clear();
        contentPane.getChildren().add(getCurrentPage());
    }

    public void finish() {
        model.save();
        stage.close();
    }

    public void cancel() {
        stage.close();
    }
}
